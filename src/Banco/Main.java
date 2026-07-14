package Banco;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner leitor = new Scanner(System.in);
        Titular titular = new Titular();
        Conta conta = new Conta();
        
        boolean access = false;
        boolean cadastrado;
        int user = -1;
        

       do{
            System.out.println("Bem vindo ao Banco PGRA!");
            System.out.println("Digite 1 para acessar sua conta!");
            Thread.sleep(3000);
            System.out.println("Digite 2 para cadastrar sua conta.");
            Thread.sleep(3000);
            System.out.println("Digite 3 para sair!");
            Thread.sleep(3000);
            System.out.print("R: ");
            int resposta = leitor.nextInt();
            switch (resposta) {
                case 1:
                    user = telaLogin(leitor, titular, conta);
                    break;
                case 2:
                    cadastrado = telaCadastro(leitor, titular);
                    break;
                case 3:
                    System.out.println("Você escolheu sair...");
                default:
                    System.out.println("Opção inexistente, encerrando o programa");
                    System.exit(1);
                    break;
            }

            if(user != -1){
                access = !access;
            } else {
                System.out.println("não foi possível acessar sua conta...");
                Thread.sleep(4000);
                break;
            }
        } while (!access);

        while (access) {
            
        }

        System.out.println("Obrigado por usar o banco PGRA");
    
        leitor.close();
    }

    //Usuário logando
    public static int telaLogin(Scanner leitor, Titular titular, Conta conta){

        int usuário = Integer.MIN_VALUE;
        String resp;
        int loop = 0;
        boolean senhaVerificada = false;
        do {
            System.out.print("Informe o numero do seu CPF: ");
            String verificandoCPF = leitor.nextLine();
            if(verificandoCPF.equalsIgnoreCase("esqueci")){
                esquecisenha();
            }
            
            System.out.print("Informe a senha: ");
            String password = leitor.nextLine();    
        
            
            senhaVerificada = conta.verificandoSenha(verificandoCPF, password);
            if (senhaVerificada == false) {
                loop +=1;
                System.out.println("usuário ou senha incorreta");
            } else {
                usuário = titular.getPosition(verificandoCPF);
            }

            System.out.print("gostaria de tentar mais uma vez?(y/n): ");
            resp = leitor.nextLine();
            

        } while (senhaVerificada != true && loop < 3 && !resp.equalsIgnoreCase("n"));

        if(senhaVerificada == false){
            usuário = -1;
        }
        
        if(loop == 3){
            System.out.println("Excesso de erro de login, encerrando o programa");
            System.exit(0);
        }

        return usuário;
    }

    public static void esquecisenha(){
        System.out.println("testando");
    }

    //definindo nome, idade e cpf
    public static boolean telaCadastro(Scanner leitor, Titular titular) throws Exception {
        boolean cadastrado = false;
        boolean titularCadastrado = false;
        do{
            //cadastrando Titular
            //cadastrando nome
            System.out.print("Por favor, informe seu nome: ");
            String nome = leitor.nextLine();
            System.out.print("informe seu sobrenome: ");
            String sobrenome = leitor.nextLine();

            String nomeCompleto = nome + " " + sobrenome;

            //cadastrando CPF
            boolean verificando;
            String cpf;
            do {
                System.out.print("Informe o seu CPF: ");
                cpf = leitor.nextLine();
                verificando = titular.verificandoCpfs(cpf);
                if (verificando == false){
                    System.out.println("Esse cpf já foi registrado, por favor informe um cpf valido.");
                } else {
                    verificando = true;
                }
            } while (verificando != true);
            

            //verificando Idade
            System.out.print("Informe sua idade: ");
            int idade = leitor.nextInt();
            leitor.nextLine(); // consome o enter

            if(nome != null && !nome.isEmpty() && cpf.length() == 11 && cpf.matches("\\d{11}") && idade >= 18){
                titular.setNomes(nomeCompleto);
                titular.setCpfs(cpf);
                titular.setIdade(idade);
                titularCadastrado = !titularCadastrado;
            } else {
                System.out.println("Informações preenchidas erroneamente, repite o passo a passo e preencha os campos corretamente.");
                Thread.sleep(4000);
                limpaTela();
            }

            //criando agencia e conta
            
        } while(!titularCadastrado != true);
        return cadastrado;
    }

    public static void limpaTela() {
        try {
            // Detecta o sistema operacional
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Linux ou Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Se não funcionar (ex: rodando em IDE), imprime várias linhas em branco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }


}
