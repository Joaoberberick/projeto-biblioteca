package service;

import model.Emprestimo;
import model.Livro;
import model.Usuario;
import repository.EmprestimoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public void registrarEmprestimo(Livro livro, Usuario usuario, LocalDate DataDevolucao) {
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            Emprestimo emprestimo = new Emprestimo(livro, usuario, LocalDate.now(), DataDevolucao,true);
            emprestimoRepository.adicionarEmprestimo(emprestimo);
        } else {
            throw new IllegalStateException("Livro não está disponível para empréstimo.");
        }
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.listarTodos();
    }

    public Emprestimo buscarEmprestimoPorIsbn(String isbn) {
        return emprestimoRepository.buscarEmprestimo(isbn);
    }

    public void devolverEmprestimo(Emprestimo emprestimo) {
        emprestimo.getLivro().setDisponivel(true);
        emprestimo.setAtivo(false);
    }
}