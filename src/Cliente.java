import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cliente extends Pessoa {
    private String rg;
    private Boolean estudante;
    public ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(String nome, String cpf, int idade, String rg, Boolean estudante) {
        super(nome, cpf, idade);
        this.rg = rg;
        this.estudante = estudante;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Boolean getEstudante() {
        return estudante;
    }

    public void setEstudante(Boolean estudante) {                       
        this.estudante = estudante;
    }

    public boolean inserir() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Clientes.txt", true))) {
            bw.write(this.nome + ";" + this.cpf + ";" + this.idade + ";" + this.rg + ";" + this.estudante);
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
            return false;
        }
    }

    public void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Idade: " + cliente.getIdade());
            System.out.println("RG: " + cliente.getRg());
            System.out.println("Estudante: " + cliente.getEstudante());
       
        } 
    }

    public void mostrar() {
        System.out.println("\n=== DADOS DO CLIENTE ===");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Idade: " + this.idade);
        System.out.println("RG: " + this.rg);
        System.out.println("Estudante: " + this.estudante);
        System.out.println("------------------------");
    }
}






