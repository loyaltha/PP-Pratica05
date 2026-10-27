package biblioteca;

public class Professor extends Usuario {
    private String departamento;

    public Professor(String nome, String departamento, ServicoNotificacao notificador) {
        super(nome, notificador);
        this.departamento = departamento;
    }

    @Override
    public int obterDiasDevolucao() {
        return 15;
    }

    @Override
    public void imprimirDados() {
        System.out.println("PROFESSOR | Nome: " + super.nome + " | Departamento: " + this.departamento);
        if (this.getEmprestimoAtivo() != null) {
            System.out.println("  -> Possui item alugado: " + this.getEmprestimoAtivo().getItem().getTitulo());
        } else {
            System.out.println("  -> Nenhum item alugado no momento.");
        }
    }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
}