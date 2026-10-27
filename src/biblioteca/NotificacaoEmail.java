package biblioteca;

public class NotificacaoEmail implements ServicoNotificacao {
    @Override
    public void notificar(String mensagem) {
        System.out.println("[E-MAIL] " + mensagem);
    }
}
