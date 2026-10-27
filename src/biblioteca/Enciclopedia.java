package biblioteca;

public class Enciclopedia implements Imprimivel, ItemAcervo {
    private String titulo;
    private int volume;

    public Enciclopedia (String titulo, int volume) {
        this.titulo = titulo;
        this.volume = volume;
        System.out.println("Enciclopédia '" + this.titulo + "' cadastrada no sistema.");
    }

    @Override
    public String getTipo() {
        return "Enciclopédia";
    }

    @Override
    public String getTitulo() {
        return titulo + " (Vol. " + volume + ")";
    }

    @Override
    public void imprimirDados() {
        System.out.println("Item de Acervo: " + getTipo() + " | " + getTitulo() + " | Status: Apenas leitura no local");
    }
}