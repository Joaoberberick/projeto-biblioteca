package repository;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository {
    private List<Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Optional<Usuario> buscarPorId(String id) {
        return usuarios.stream().filter(usuario -> usuario.getId().equals(id)).findFirst();
    }

    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    public boolean removerUsuario(String id) {
        return usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }

    public boolean existeId(String id) {
        return usuarios.stream().anyMatch(usuario -> usuario.getId().equals(id));
    }
}