package service;

import model.Usuario;
import repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarioRepository.adicionarUsuario(usuario);
    }

    public Optional<Usuario> buscarPorId(String id) {
        return usuarioRepository.buscarPorId(id);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.listarTodos();
    }

    public boolean removerUsuario(String id) {
        return usuarioRepository.removerUsuario(id);
    }

    public boolean existeId(String id) {
        return usuarioRepository.existeId(id);
    }
}