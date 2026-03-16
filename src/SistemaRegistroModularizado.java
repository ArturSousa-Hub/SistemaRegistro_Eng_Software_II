
class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
}


class UsuarioRepository {
    public void salvar(Usuario usuario) {
        System.out.println("\n[Banco de Dados] Abrindo conexão...");
        String sql = "INSERT INTO usuarios (nome, email) VALUES ('" + usuario.getNome() + "', '" + usuario.getEmail() + "')";
        System.out.println("[Banco de Dados] Executando: " + sql);
    }
}


class EmailService {
    public void enviarEmailBoasVindas(String destinatario, String nome) {
        System.out.println("\n[Serviço de Email] Conectando ao servidor SMTP...");
        System.out.println("[Serviço de Email] Enviando email para: " + destinatario);
        System.out.println("[Serviço de Email] Corpo: Olá " + nome + ", seu registro foi concluído!");
    }
}


class RegistroUsuarioService {
    private UsuarioRepository repository;
    private EmailService emailService;

    public RegistroUsuarioService(UsuarioRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    public void registrar(String nome, String email, String senha) {
        if (nome == null || nome.isEmpty() || email == null || !email.contains("@") || senha == null || senha.length() < 6) {
            throw new IllegalArgumentException("Erro de Validação: Dados do usuário são inválidos.");
        }

        Usuario novoUsuario = new Usuario(nome, email, senha);
        repository.salvar(novoUsuario);
        emailService.enviarEmailBoasVindas(email, nome);
    }
}


public class SistemaRegistroModularizado {
    public static void main(String[] args) {

        UsuarioRepository repository = new UsuarioRepository();
        EmailService emailService = new EmailService();


        RegistroUsuarioService servicoDeRegistro = new RegistroUsuarioService(repository, emailService);

        System.out.println("Iniciando o processo de registro de usuário...");

        try {

            servicoDeRegistro.registrar("Artur", "artur@exemplo.com", "senha123");
            System.out.println("\nProcesso finalizado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nFalha no registro: " + e.getMessage());
        }
    }
}