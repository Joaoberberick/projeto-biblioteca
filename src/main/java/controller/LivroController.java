package controller;

import model.Livro;
import service.LivroService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LivroController {
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    public void processarNovoLivro(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do livro: ");
        String livroID = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        adicionarLivro(livroID, isbn, titulo, autor);
        System.out.println("Livro adicionado com sucesso!");
    }

    public void adicionarLivro(String id, String titulo, String isbn, String autor) {
        if (livroService.existeIsbn(isbn)) {
            throw new RuntimeException("Já existe um livro com o ISBN informado: " + isbn);
        }
        Livro livro = new Livro(id, isbn, titulo, autor);
        livroService.adicionarLivro(livro);
    }

    public void buscarLivroPorIsbn(String isbn) {
        Optional<Livro> livro = livroService.buscarPorIsbn(isbn);
        livro.ifPresentOrElse(
                l -> System.out.println("Livro encontrado: " + l),
                () -> System.out.println("Livro com ISBN " + isbn + " não encontrado.")
        );
    }

    public void listarTodosLivros() {
        List<Livro> livros = livroService.listarTodos();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    public void processarRemoverLivro(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ISBN do livro a ser removido: ");
        String isbnRemover = scanner.nextLine();
        removerLivro(isbnRemover);
        System.out.println("Livro removido com sucesso!");
    }

    public void removerLivro(String isbn) {
        if (livroService.removerLivro(isbn)) {
        } else {
            System.out.println("Livro com ISBN " + isbn + " não encontrado.");
        }
    }
}