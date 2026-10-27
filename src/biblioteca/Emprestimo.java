package biblioteca;

public class Emprestimo implements Imprimivel {
    private Usuario usuario;
    private ItemEmprestavel item;
    private ServicoNotificacao notificador;
    private boolean ativo;

    public Emprestimo(Usuario usuario, ItemEmprestavel item, ServicoNotificacao notificador) {
        this.usuario = usuario;
        this.item = item;
        this.notificador = notificador;
        this.ativo = true;
    }

    // Método responsável por mediar o aluguel
    public static Emprestimo registrar(Usuario usuario, ItemEmprestavel item, ServicoNotificacao notificador) {
        if (usuario.getEmprestimoAtivo() != null) {
            notificador.notificar(usuario.getNome() + " já possui o item '" + usuario.getEmprestimoAtivo().getItem().getTitulo() + "' em mãos.");
            return null;
        }
        if (!item.getDisponivel()) {
            notificador.notificar("O item '" + item.getTitulo() + "' não está disponível no momento.");
            return null;
        }

        item.setDisponivel(false);
        Emprestimo novoEmprestimo = new Emprestimo(usuario, item, notificador);
        usuario.setEmprestimoAtivo(novoEmprestimo);

        notificador.notificar(usuario.getNome() + " alugou o item (" + item.getTipo() + "): " + item.getTitulo());
        notificador.notificar("Prazo para devolução: " + usuario.obterDiasDevolucao() + " dias.");
        return novoEmprestimo;
    }

    // Método responsável por mediar a renovação
    public boolean renovar() {
        if (!this.ativo) {
            return false;
        }
        notificador.notificar(usuario.getNome() + " RENOVOU o item: " + item.getTitulo());
        notificador.notificar("Novo prazo para devolução: " + usuario.obterDiasDevolucao() + " dias a partir de hoje.");
        return true;
    }

    // Método responsável por mediar a devolução
    public void finalizar() {
        if (!this.ativo) {
            notificador.notificar("Este empréstimo já foi encerrado.");
            return;
        }
        this.item.setDisponivel(true);
        this.usuario.setEmprestimoAtivo(null);
        this.ativo = false;
        notificador.notificar(this.usuario.getNome() + " devolveu o item: " + this.item.getTitulo());
    }

    @Override
    public void imprimirDados() {
        System.out.println("EMPRÉSTIMO | Usuário: " + usuario.getNome() + 
                           " | Item (" + item.getTipo() + "): " + item.getTitulo() + 
                           " | Status Ativo: " + (ativo ? "Sim" : "Não"));
    }

    public Usuario getUsuario() { return usuario; }
    public ItemEmprestavel getItem() { return item; }
    public boolean isAtivo() { return ativo; }
}