import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner leitor = new Scanner(System.in);
        

        int loop = 0;
        
        boolean access = false;
        boolean logando = false;
        

        while (!logando){
            System.out.println("Entrou!");
            telaLogin(leitor);
            logando = !logando;
            
        }



        while (access) {
            
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

        System.out.println("Obrigado por usar o banco PGRA");
    
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
        if(verificandoCPF.equalsIgnoreCase(verificandoCPF)){
            esquecisenha();
        }
        

    }

    public static void esquecisenha(){
        System.out.println("testando");
    }

}
