import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ator extends Pessoa {
    private int registroProfissional;
    public  ArrayList<Ator> atores = new ArrayList<>();

    public Ator(String cpf, String nome, int idade, int registroProfissional) {
        super(cpf, nome, idade);
        this.registroProfissional = registroProfissional;

    }

    public int getRegistroProfissional() {  
        return registroProfissional;
    }

    public void setRegistroProfissional(int registroProfissional) {
        this.registroProfissional = registroProfissional;
    }


    public boolean inserir() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Atores.txt", true))) {
            bw.write(this.nome + ";" + this.cpf + ";" + this.idade + ";" + this.registroProfissional);
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
            return false;
        }
    }

    public void listarAtores() {
        System.out.println("\n=== LISTA DE ATORES ===");
        for (Ator ator : atores) {
            System.out.println("Nome: " + ator.getNome());
            System.out.println("CPF: " + ator.getCpf());
            System.out.println("Idade: " + ator.getIdade());
            System.out.println("Registro profissional: " + ator.getRegistroProfissional());
      
        }
    }

    public void mostrar() {
        System.out.println("\n=== DADOS DO ATOR ===");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Idade: " + this.idade);
        System.out.println("Registro profissional: " + this.registroProfissional);
        System.out.println("------------------------");
    }
} 