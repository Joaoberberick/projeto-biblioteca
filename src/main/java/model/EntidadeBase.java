package model;

public abstract class EntidadeBase {
    private String id;
    private String nome;

    public EntidadeBase(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "EntidadeBase{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}