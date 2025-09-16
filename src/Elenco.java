import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Elenco {
    private int idElenco;
    private Ator ator;
    private Filme filme;
    private Boolean atorPrincipal;
    private static ArrayList<Elenco> elencos = new ArrayList<>();

    public Elenco(int idElenco, Ator ator, Filme filme, Boolean atorPrincipal) {
        this.idElenco = idElenco;
        this.ator = ator;
        this.filme = filme;
        this.atorPrincipal = atorPrincipal;
    }

    public int getIdElenco() {
        return idElenco;
    }

    public void setIdElenco(int idElenco) {
        this.idElenco = idElenco;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Boolean getAtorPrincipal() {
        return atorPrincipal;
    }

    public void setAtorPrincipal(Boolean atorPrincipal) {
        this.atorPrincipal = atorPrincipal;
    }

    public boolean inserir() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Elencos.txt", true))) {
            bw.write(this.idElenco + ";" + this.ator.getCpf() + ";" + this.filme.getTitulo() + ";" + this.atorPrincipal);
            bw.newLine();
            elencos.add(this);
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
            return false;
        }
    }

    public void mostrar() {
        System.out.println("\n=== DADOS DO ELENCO ===");
        System.out.println("ID: " + this.idElenco);
        System.out.println("Ator: " + this.ator.getNome());
        System.out.println("Filme: " + this.filme.getTitulo());
        System.out.println("Ator Principal: " + (this.atorPrincipal ? "Sim" : "Não"));
        System.out.println("------------------------");
    }

    public  void listarElencos() {
        System.out.println("\n=== LISTA DE ELENCOS ===");
        for (Elenco elenco : elencos) {
            System.out.println("ID: " + elenco.getIdElenco());
            System.out.println("Ator: " + elenco.getAtor().getNome());
            System.out.println("Filme: " + elenco.getFilme().getTitulo());
            System.out.println("Ator Principal: " + elenco.getAtorPrincipal());
            System.out.println("------------------------");
        }
    }

    public static Elenco consultar(int id) {
        for (Elenco e : elencos) {
            if (e.getIdElenco() == id) {
                return e;
            }
        }
        return null;
    }
    











} 