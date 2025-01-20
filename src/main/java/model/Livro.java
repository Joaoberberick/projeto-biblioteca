package model;

public class Livro extends EntidadeBase {
    private String isbn;
    private String autor;
    private boolean disponivel;

    public Livro(String id, String nome, String isbn, String autor) {
        super(id, nome);
        this.isbn = isbn;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}