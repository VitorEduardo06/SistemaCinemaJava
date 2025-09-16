import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ingresso {
    private int idIngresso;
    private Double valor;
    private Boolean meiaEntrada;
    private Boolean gratuidade;
    private Boolean utilizado;
    private Sessao sessao;
    private Cliente cliente;
    private static ArrayList<Ingresso> ingressos = new ArrayList<>();

    public Ingresso(int idIngresso, Double valor, Boolean meiaEntrada, Boolean gratuidade, Boolean utilizado, Sessao sessao, Cliente cliente) {
        this.idIngresso = idIngresso;
        this.valor = valor;
        this.meiaEntrada = meiaEntrada;
        this.gratuidade = gratuidade;
        this.utilizado = utilizado;
        this.sessao = sessao;
        this.cliente = cliente;
    }

    public int getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }   

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        try {
            if (valor < 0) {
                throw new ArithmeticException("Valor não pode ser negativo");
            }
            if (this.meiaEntrada && valor > 0) {
                valor = valor / 2;
            }
            this.valor = valor;
        } catch (ArithmeticException e) {
            System.out.println("Erro ao definir valor: " + e.getMessage());
        }
    }

    public Boolean getMeiaEntrada() {
        return meiaEntrada;
    }

    public void setMeiaEntrada(Boolean meiaEntrada) {
        this.meiaEntrada = meiaEntrada;
    }

    public Boolean getGratuidade() {
        return gratuidade;
    }

    public void setGratuidade(Boolean gratuidade) {
        this.gratuidade = gratuidade;
    }   

    public Boolean getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(Boolean utilizado) {
        this.utilizado = utilizado;
    }   

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }   

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }   

    public boolean inserir() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Ingressos.txt", true))) {
            bw.write(this.idIngresso + ";" + this.valor + ";" + this.cliente.getCpf() + ";" + this.sessao.getIdSessao());
            bw.newLine();
            ingressos.add(this);
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
            return false;
        }
    }

    public static void listarIngressos() {
        System.out.println("\n=== LISTA DE INGRESSOS ===");
        for (Ingresso ingresso : ingressos) {
            System.out.println("ID: " + ingresso.getIdIngresso());
            System.out.println("Valor: R$ " + ingresso.getValor());
            System.out.println("Cliente: " + ingresso.getCliente().getNome());
            System.out.println("Sessão: " + ingresso.getSessao().getIdSessao());

        }
    }

    public void mostrar() {
        System.out.println("\n=== DADOS DO INGRESSO ===");
        System.out.println("ID: " + this.idIngresso);
        System.out.println("Valor: R$ " + this.valor);
        System.out.println("Meia Entrada: " + (this.meiaEntrada ));
        System.out.println("Gratuito: " + (this.gratuidade ));
        System.out.println("Utilizado: " + (this.utilizado ));
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Sessão: " + this.sessao.getIdSessao());
        
    }
} 