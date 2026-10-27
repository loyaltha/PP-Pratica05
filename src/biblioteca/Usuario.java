package biblioteca;

public abstract class Usuario implements Imprimivel {
    protected String nome;
    private Emprestimo emprestimoAtivo; // Associação indireta através do mediador
    protected ServicoNotificacao notificador; // Dependência de uma abstração (DIP)

    // Construtor com Injeção de Dependência (DIP)
    public Usuario(String nome, ServicoNotificacao notificador) {
        this.nome = nome;
        this.notificador = notificador;
    }

    public abstract int obterDiasDevolucao();

    // Delega a ação de alugar para o mediador Emprestimo (dependendo da abstração ItemEmprestavel)
    public boolean alugar(ItemEmprestavel item) {
        Emprestimo emp = Emprestimo.registrar(this, item, this.notificador);
        return emp != null; // Se retornou um objeto, o aluguel deu certo
    }

    // Sobrecarga do método alugar delegando para o mediador
    public boolean alugar(ItemEmprestavel item, boolean renovacao) {
        if (renovacao) {
            if (this.emprestimoAtivo == null || !this.emprestimoAtivo.getItem().equals(item)) {
                this.notificador.notificar(this.nome + " não pode renovar um item que não está em sua posse.");
                return false;
            }
            return this.emprestimoAtivo.renovar();
        } else {
            return this.alugar(item); 
        }
    }

    // Delega a devolução para o mediador
    public void devolver() {
        if (this.emprestimoAtivo == null) {
            this.notificador.notificar(this.nome + " não tem nenhum item para devolver.");
            return;
        }
        this.emprestimoAtivo.finalizar();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Emprestimo getEmprestimoAtivo() { return emprestimoAtivo; }
    public void setEmprestimoAtivo(Emprestimo emprestimoAtivo) { this.emprestimoAtivo = emprestimoAtivo; }

    public ServicoNotificacao getNotificador() { return notificador; }
    public void setNotificador(ServicoNotificacao notificador) { this.notificador = notificador; }
}