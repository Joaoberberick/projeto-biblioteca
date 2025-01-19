package controller;

import model.Livro;
import model.Usuario;
import model.Emprestimo;
import repository.LivroRepository;
import repository.UsuarioRepository;
import service.EmprestimoService;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class EmprestimoController {
    private EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    public void processarNovoEmprestimo(LivroRepository livros, UsuarioRepository usuarios){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ISBN do livro: ");
        String isbnEmprestimo = scanner.nextLine();
        System.out.print("ID do usuário: ");
        String idUsuario = scanner.nextLine();
        Livro livro = livros.buscarPorIsbn(isbnEmprestimo).orElseThrow(() -> new RuntimeException("Livro não encontrado!"));
        Usuario usuario = usuarios.buscarPorId(idUsuario).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        LocalDate hoje = LocalDate.now();
        LocalDate dataDevolucao = hoje.plusDays(30);
        registrarEmprestimo(livro, usuario, dataDevolucao);
        System.out.println("Empréstimo registrado com sucesso!");
    }

    public void registrarEmprestimo(Livro livro, Usuario usuario, LocalDate dataDevolucao) {
        try {
            emprestimoService.registrarEmprestimo(livro, usuario, dataDevolucao);
        } catch (IllegalStateException e) {
            System.out.println("Erro ao registrar empréstimo: " + e.getMessage());
        }
    }

    public void listarTodosEmprestimos() {
        emprestimoService.listarTodos().forEach(System.out::println);
    }
}
