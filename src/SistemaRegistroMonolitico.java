public class SistemaRegistroMonolitico {

    public void registrarENotificarUsuario(String nome, String email, String senha) {

        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido.");
        }
        if (senha == null || senha.length() < 6) {
            throw new IllegalArgumentException("Senha muito fraca.");
        }


        System.out.println("Abrindo conexão com o banco de dados...");
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES ('" + nome + "', '" + email + "', '" + senha + "')";
        System.out.println("Executando: " + sql);
        System.out.println("Usuário salvo no banco de dados.");


        System.out.println("Conectando ao servidor SMTP...");
        System.out.println("Enviando email para: " + email);
        System.out.println("Corpo: Olá " + nome + ", seu registro foi concluído com sucesso!");
        System.out.println("Email enviado.");
    }

    public static void main(String[] args) {
        SistemaRegistroMonolitico sistema = new SistemaRegistroMonolitico();
        sistema.registrarENotificarUsuario("Artur", "artur@exemplo.com", "senha123");
    }
}