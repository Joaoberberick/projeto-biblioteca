package controller;

import model.Usuario;
import service.UsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void processarNovoUsuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        adicionarUsuario(id, nome, email);
        System.out.println("Usuário adicionado com sucesso!");
    }

    public void adicionarUsuario(String id, String nome, String email) {
        if (usuarioService.existeId(id)) {
            throw new RuntimeException("Já existe um usuário com o ID informado: " + id);
        }
        Usuario usuario = new Usuario(id, nome, email);
        usuarioService.adicionarUsuario(usuario);
    }

    public void buscarUsuarioPorId(String id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        usuario.ifPresentOrElse(
                u -> System.out.println("Usuário encontrado: " + u),
                () -> System.out.println("Usuário com ID " + id + " não encontrado.")
        );
    }

    public void listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            usuarios.forEach(System.out::println);
        }
    }

    public void processarRemoverUsuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do usuário a ser removido: ");
        String idRemover = scanner.nextLine();
        removerUsuario(idRemover);
    }

    public void removerUsuario(String id) {
        if (usuarioService.removerUsuario(id)) {
            System.out.println("Usuário removido com sucesso!");
        } else {
            System.out.println("Usuário com ID " + id + " não encontrado.");
        }
    }
}