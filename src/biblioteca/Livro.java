package biblioteca;

public class Livro implements Imprimivel, ItemEmprestavel {
    // Atributos privados (Encapsulamento)
    private String titulo;
    private String autor;
    private boolean disponivel = true; // Disponibilidade do livro

    // Atributo Estático
    private static int totalLivros = 0;

    // Construtor
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        Livro.totalLivros++;
        System.out.println("Livro '" + this.titulo + "' cadastrado no sistema.");
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

    // Métodos Getters e Setters
    @Override
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    @Override
    public boolean getDisponivel() { return disponivel; }
    @Override
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel;}

    public static int getTotalLivros() { return totalLivros; }

    // Método da interface
    @Override
    public void imprimirDados() {
        System.out.println("Livro: " + this.titulo + " | Autor: " + this.autor);
    }
}
