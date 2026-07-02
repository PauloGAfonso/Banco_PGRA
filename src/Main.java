import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner leitor = new Scanner(System.in);
        Titular titular = new Titular();

        int loop = 0;
        
        boolean access = false;
        boolean logando = false;
        

        while (!logando){
            System.out.println("Entrou!");
            logando = telaInicial(leitor, titular);
            if(logando = true){
                access = !access;
            }
        }
        while (access) {
            
            telaInicial(leitor, titular);
            int escolha = leitor.nextInt();
            leitor.nextLine();
        
        }

        System.out.println("Obrigado por usar o banco PGRA");
    
        leitor.close();
    }

    public static boolean telaInicial(Scanner leitor, Titular titular){

        boolean logou = false;
        System.out.println("Digite 1 para acessar sua conta!");
        System.out.println("Digite 2 para cadastrar sua conta.");
        System.out.println("Digite 3 para sair!");
        int escolha = leitor.nextInt();
        switch (escolha) {
            case 1:
                logou = telaLogin(leitor);
                break;
            case 2:
                logou = telaCadastro(leitor, titular);
                break;
            case 3:
                System.out.println("Você escolheu sair...");
            default:
                System.out.println("Opção inexistente, encerrando o programa");
                System.exit(1);
                break;
        }
        return logou;
    }

    public static boolean telaLogin(Scanner leitor){
        System.out.print("Informe o numero da cpf");
        String verificandoCPF = leitor.nextLine();
        if(verificandoCPF.equalsIgnoreCase(verificandoCPF)){
            esquecisenha();
        }
        return true;
    }

    public static void esquecisenha(){
        System.out.println("testando");
    }

    //definindo nome, idade e cpf
    public static boolean telaCadastro(Scanner leitor, Titular titular){
        boolean cadastrado = false;
        while(!cadastrado){
            System.out.print("Por favor, informe seu nome: ");
            String nome = leitor.nextLine();

            System.out.print("Informe o seu CPF: ");
            String cpf = leitor.nextLine();

            System.out.println("Informe sua idade: ");
            int idade = leitor.nextInt();
            leitor.nextLine(); // consome o enter

            if(nome != null && !nome.isEmpty() && cpf.length() == 11 && cpf.matches("\\d{11}") && idade >= 18){
                titular.setNomes(nome);
                titular.setCpfs(cpf);
                titular.setIdade(idade);
                cadastrado = !cadastrado;
            } else {
                System.out.println("Informações preenchidas erroneamente, repite o passo a passo e preencha os campos corretamente.");
            }
        }

        return cadastrado;
    }

}
