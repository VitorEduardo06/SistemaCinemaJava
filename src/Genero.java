import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Genero {
    private int idGenero;
    private String descGenero;
    private static ArrayList<Genero> generos = new ArrayList<>();

    public Genero(int idGenero, String descGenero) {
        this.idGenero = idGenero;
        this.descGenero = descGenero;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getDescGenero() {
        return descGenero;
    }

    public void setDescGenero(String descGenero) {
        this.descGenero = descGenero;
    }

    public boolean inserir() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Generos.txt", true))) {
            bw.write(this.idGenero + ";" + this.descGenero);
            bw.newLine();
            generos.add(this);
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
            return false;
        }
    }

    public static void listarGeneros() {
        System.out.println("\n=== LISTA DE GÊNEROS ===");
        for (Genero genero : generos) {
            System.out.println("ID: " + genero.getIdGenero());
            System.out.println("Descrição: " + genero.getDescGenero());
            System.out.println("------------------------");
        }
    }

    public void mostrar() {
        System.out.println("\n=== DADOS DO GÊNERO ===");
        System.out.println("ID: " + this.idGenero);
        System.out.println("Descrição: " + this.descGenero);
        System.out.println("------------------------");
    }
} 