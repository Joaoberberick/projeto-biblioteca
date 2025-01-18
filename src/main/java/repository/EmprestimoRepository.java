package repository;

import model.Emprestimo;
import model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmprestimoRepository {
    private List<Emprestimo> emprestimos;

    public EmprestimoRepository() {
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public List<Emprestimo> listarTodos() {
        return emprestimos.stream()
                .filter(Emprestimo::isAtivo)
                .collect(Collectors.toList());
    }

    public Emprestimo buscarEmprestimo(String isbn){
        return emprestimos.stream()
                .filter(emprestimo -> emprestimo.getLivro().getIsbn().equals(isbn) && emprestimo.isAtivo())
                .findFirst()
                .orElse(null);
    }
}