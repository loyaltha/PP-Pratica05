package biblioteca;

public class Aluno extends Usuario {
    private int matricula;

    public Aluno(String nome, int matricula, ServicoNotificacao notificador) {
        super(nome, notificador);
        this.matricula = matricula;
    }

    @Override
    public int obterDiasDevolucao() {
        return 7;
    }

    @Override
    public void imprimirDados() {
        System.out.println("ALUNO | Nome: " + super.nome + " | Matrícula: " + this.matricula);
        if (this.getEmprestimoAtivo() != null) {
            System.out.println("  -> Possui item alugado: " + this.getEmprestimoAtivo().getItem().getTitulo());
        } else {
            System.out.println("  -> Nenhum item alugado no momento.");
        }
    }

    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }
}