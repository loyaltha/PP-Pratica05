package biblioteca;

public class Revista implements Imprimivel, ItemEmprestavel {
    private String titulo;
    private int edicao;
    private boolean disponivel = true;

    public Revista(String titulo, int edicao) {
        this.titulo = titulo;
        this.edicao = edicao;
        System.out.println("Revista '" + this.titulo + "' cadastrada no sistema.");
    }
    @Override
    public String getTipo() {
        return "Revista";
    }

    @Override
    public String getTitulo() {
        return titulo + " (Ed. " + edicao + ")";
    }

    @Override
    public boolean getDisponivel() {
        return disponivel;
    }

    @Override
    public void setDisponivel(boolean status) {
        this.disponivel = status;
    }

    @Override
    public void imprimirDados() {
        System.out.println("Item de Acervo: " + getTipo() + " | " + getTitulo() + " | Disponível: " + (disponivel ? "Sim" : "Não"));
    }

    public int getEdicao() { return edicao; }
    public void setEdicao(int edicao) { this.edicao = edicao; }
}