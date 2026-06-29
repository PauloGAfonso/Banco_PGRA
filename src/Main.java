import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner leitor = new Scanner(System.in);
        

        int loop = 0;
        
        boolean running = true;
        

        System.out.println(" SEJA BEM VINDO AO BANCO PG ");
        System.out.println(" Aqui garantimos a sua segurança financeira ");

        while (running) {
            
            telaInicial();
            int escolha = leitor.nextInt();
            leitor.nextLine();

            switch (escolha) {
                case 1:
                    telaLogin(leitor);
                    break;
            
                default:
                    break;
            }
        
        }
    
        leitor.close();
    }

    public static void telaInicial(){
        System.out.println("Digite 1 para acessar sua conta!");
        System.out.println("Digite 2 para cadastrar sua conta.");
        System.out.println("Digite 3 para sair!");
    }

    public static void telaLogin(Scanner leitor){
        System.out.print("Informe o numero da cpf");
        String verificandoCPF = leitor.nextLine();
        

    }

}
