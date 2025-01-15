package repository;

import model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroRepository {
    private List<Livro> livros;

    public LivroRepository() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public Optional<Livro> buscarPorIsbn(String isbn) {
        return livros.stream().filter(livro -> livro.getIsbn().equals(isbn)).findFirst();
    }

    public List<Livro> listarTodos() {
        return new ArrayList<>(livros);
    }

    public boolean removerLivro(String isbn) {
        return livros.removeIf(livro -> livro.getIsbn().equals(isbn));
    }
}