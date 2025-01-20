package model;

public class Usuario extends EntidadeBase {
    private String email;

    public Usuario(String id, String nome, String email) {
        super(id, nome);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
