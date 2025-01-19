package service;

import model.Livro;
import repository.LivroRepository;

import java.util.List;
import java.util.Optional;

public class LivroService {
    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void adicionarLivro(Livro livro) {
        livroRepository.adicionarLivro(livro);
    }

    public Optional<Livro> buscarPorIsbn(String isbn) {
        return livroRepository.buscarPorIsbn(isbn);
    }

    public List<Livro> listarTodos() {
        return livroRepository.listarTodos();
    }

    public boolean removerLivro(String isbn) {
        return livroRepository.removerLivro(isbn);
    }

    public boolean existeIsbn(String isbn) {
        return livroRepository.existeIsbn(isbn);
    }
}