import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sessao {
    private int idSessao;
    private String dataSessao;
    private String horaSessao;
    private int classificacao;
    private Filme filme;
    private static ArrayList<Sessao> sessoes = new ArrayList<>();

    public Sessao(int idSessao, String dataSessao, String horaSessao, int classificacao, Filme filme) {
        this.idSessao = idSessao;
        this.dataSessao = dataSessao;
        this.horaSessao = horaSessao;
        this.classificacao = classificacao;
        this.filme = filme;
    }

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public String getDataSessao() {
        return dataSessao;
    }

    public void setDataSessao(String dataSessao) {
        this.dataSessao = dataSessao;
    }   

    public String getHoraSessao() {
        return horaSessao;
    }

    public void setHoraSessao(String horaSessao) {
        this.horaSessao = horaSessao;
    }   

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public boolean inserir() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Sessoes.txt", true))) {
            bw.write(this.idSessao + ";" + this.dataSessao + ";" + this.horaSessao + ";" + this.classificacao + ";" + this.filme.getTitulo());
            bw.newLine();
            sessoes.add(this);
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
            return false;
        }
    }

    public static void listarSessoes() {
        System.out.println("\n=== LISTA DE SESSÕES ===");
        for (Sessao sessao : sessoes) {
            System.out.println("ID: " + sessao.getIdSessao());
            System.out.println("Data: " + sessao.getDataSessao());
            System.out.println("Hora: " + sessao.getHoraSessao());
            System.out.println("Classificação: " + sessao.getClassificacao());
            System.out.println("Filme: " + sessao.getFilme().getTitulo());
            System.out.println("------------------------");
        }
    }

    public void mostrar() {
        System.out.println("\n=== DADOS DA SESSÃO ===");
        System.out.println("ID: " + this.idSessao);
        System.out.println("Data: " + this.dataSessao);
        System.out.println("Hora: " + this.horaSessao);
        System.out.println("Classificação: " + this.classificacao);
        System.out.println("Filme: " + this.filme.getTitulo());
        System.out.println("------------------------");
    }
} 