package biblioteca;

public class NotificacaoConsole implements ServicoNotificacao {
    @Override
    public void notificar(String mensagem) {
        System.out.println("[CONSOLE] " + mensagem);
    }
}
