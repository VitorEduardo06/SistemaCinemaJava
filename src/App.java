import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos m1 = new Metodos();

        while (true) {
            
            try {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1 - Gerenciar Atores");
                System.out.println("2 - Gerenciar Clientes");
                System.out.println("3 - Gerenciar Generos ");
                System.out.println("4 - Gerenciar Sessoes " );
                System.out.println("5 - Gerenciar Filmes " );
                System.out.println("6 - Gerenciar Ingressos " );
                System.out.println("7 - Gerenciar  Elenco" );
                System.out.println("8 - Sair " );
                System.out.print("Digite sua opção: ");
                int opcao = sc.nextInt();
                sc.nextLine(); 

            switch (opcao) {
                case 1:
                m1.menuAtores();
                    break;

                case 2: 
                    m1.menuClientes();
                break;
                case 3:
                    m1.menuGeneros();
                break;
                case 4:
                    m1.menuSessoes();
                break;
                case 5: 
                m1.menuFilmes();
                break;
                case 6: 
                
                m1.menuIngressos();
                break;
                case 7: 
                m1.menuElenco();
                break;
                case 8:
                System.out.println("Encerrando o programa...");
                System.exit(0
                );
                break;            
                }
            }  catch (InputMismatchException e) {
                    System.out.println("Erro: Por favor, digite uma entrada valida!");
                sc.nextLine(); 
                }
                catch (Exception e){
                System.out.println("Error: "+ e.getMessage()) ;
                sc.nextLine();
                }
            
            } 









          
            










        }
        
        



    }


    