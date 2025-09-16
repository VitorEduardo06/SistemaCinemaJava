import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filme {
    private int idFilme;
    private String titulo;
    private int duracao;
    private Genero genero;
    private static ArrayList<Filme> filmes = new ArrayList<>();

    public Filme(int idFilme, String titulo, int duracao, Genero genero) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }   

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean inserir() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Filmes.txt", true))) {
            bw.write(this.idFilme + ";" + this.titulo + ";" + this.duracao + ";" + this.genero.getIdGenero());
            bw.newLine();
            filmes.add(this);
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
            return false;
        }
    }

    public static void listarFilmes() {
        System.out.println("\n=== LISTA DE FILMES ===");
        for (Filme filme : filmes) {
            System.out.println("ID: " + filme.getIdFilme());
            System.out.println("Título: " + filme.getTitulo());
            System.out.println("Duração: " + filme.getDuracao() + " minutos");
            System.out.println("Gênero: " + filme.getGenero().getDescGenero());
            System.out.println("------------------------");
        }
    }

    public void mostrar() {
        System.out.println("\n=== DADOS DO FILME ===");
        System.out.println("ID: " + this.idFilme);
        System.out.println("Título: " + this.titulo);
        System.out.println("Duração: " + this.duracao + " minutos");
        System.out.println("Gênero: " + this.genero.getDescGenero());
        System.out.println("------------------------");
    }
} 