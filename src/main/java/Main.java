import controller.LivroController;
import controller.UsuarioController;
import controller.EmprestimoController;
import model.Livro;
import model.Usuario;
import repository.LivroRepository;
import repository.UsuarioRepository;
import repository.EmprestimoRepository;
import service.LivroService;
import service.UsuarioService;
import service.EmprestimoService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializando componentes do sistema
        LivroRepository livroRepository = new LivroRepository();
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        EmprestimoRepository emprestimoRepository = new EmprestimoRepository();

        LivroService livroService = new LivroService(livroRepository);
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        EmprestimoService emprestimoService = new EmprestimoService(emprestimoRepository);

        LivroController livroController = new LivroController(livroService);
        UsuarioController usuarioController = new UsuarioController(usuarioService);
        EmprestimoController emprestimoController = new EmprestimoController(emprestimoService);

        livroController.adicionarLivro("6555521589", "A Odisseia", "Homero", true);
        livroController.adicionarLivro("6555521635", "Iliada", "Homero", true);
        livroController.adicionarLivro("854400119X", "Fausto", "Goethe", true);
        livroController.adicionarLivro("6580210621", "Dom Quixote", "Cervantes", true);

        usuarioController.adicionarUsuario("1", "Joao", "teste@teste");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Sistema de Biblioteca ===");

        while (running) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Remover Livro");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Adicionar Usuário");
            System.out.println("5 - Remover Usuário");
            System.out.println("6 - Listar Usuários");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção: ");

            String opcao = scanner.nextLine();

            try {
                switch (opcao) {
                    case "1": // Adicionar Livro
                        livroController.processarNovoLivro();
                        break;

                    case "2": // Remover Livro
                        livroController.processarRemoverLivro();
                        break;

                    case "3": // Listar Livros
                        livroController.listarTodosLivros();
                        break;

                    case "4": // Adicionar Usuário
                        usuarioController.processarNovoUsuario();
                        break;

                    case "5": // Remover Usuário
                        usuarioController.processarRemoverUsuario();
                        break;

                    case "6": // Listar Usuários
                        usuarioController.listarTodosUsuarios();
                        break;

                    case "0": // Sair
                        running = false;
                        System.out.println("Saindo do sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
