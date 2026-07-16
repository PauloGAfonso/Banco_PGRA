package Banco;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner leitor = new Scanner(System.in);
        Titular titular = new Titular();
        Conta conta = new Conta();
        Random random = new Random();
        
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
                    cadastrado = telaCadastro(leitor, titular, conta, random);
                    break;
                case 3:
                    System.out.println("Você escolheu sair...");
                    break;
                default:
                    System.out.println("Opção inexistente, encerrando o programa");
                    System.exit(1);
                    break;
            }

            if(user > -1){
                access = true;
            } else {
                System.out.println("não foi possível acessar sua conta...");
                Thread.sleep(4000);
                break;
            }
        } while (access = false);

        //pós logado
        if(access){
            do {
                
            } while (true);
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

    public static boolean telaCadastro(Scanner leitor, Titular titular, Conta conta ,Random random) throws Exception {
        boolean titularCadastrado = false;
        boolean agencia = false;
        boolean account = false;

        do{
            titularCadastrado = cadastrandoUsuario(titular, leitor);
            agencia = cadastrandoAgencia(conta, random);
            account = cadastrandoConta(conta, random);
        }while(!(titularCadastrado && agencia && account));

        if(titularCadastrado && agencia && account){
            return true;
        } else {
            return false;
        }
    }

    public static boolean cadastrandoUsuario(Titular titular, Scanner leitor) throws Exception{
        boolean titularCadastrado = false;
        do{
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
                if (verificando == true){
                    System.out.println("Esse cpf já foi registrado, por favor informe um cpf valido.");
                }
            } while (verificando != false);
            
            //verificando Idade
            System.out.print("Informe sua idade: ");
            int idade = leitor.nextInt();
            leitor.nextLine(); // consome o enter
            if(idade < 18){
                System.out.println("Você não tem idade permitida para criar uma conta, encerrando o programa...");
            }


            if(nomeCompleto != null && !nomeCompleto.isEmpty() && cpf.length() == 11 && cpf.matches("\\d{11}") && idade >= 18){
                titular.setNomes(nomeCompleto);
                titular.setCpfs(cpf);
                titular.setIdade(idade);
                titularCadastrado = true;
                System.out.println("Titular cadastrado corretamente");
                Thread.sleep(5000);
                limpaTela();
            } else {
                System.out.println("Informações preenchidas erroneamente, repite o passo a passo e preencha os campos corretamente.");
                Thread.sleep(4000);
                limpaTela();
            }
        } while(titularCadastrado != true);

        return titularCadastrado;
    }

    public static boolean cadastrandoAgencia(Conta conta, Random random){
        System.out.println("Estamos criando sua agência... Aguarde uns segundos...");
        String agencia;
        boolean ag = false;
        do {
            int numero = random.nextInt(10000);
            int digito = random.nextInt(10);
            agencia = String.format("%04d-%d", numero, digito);
            if (conta.verificandoAgencia(agencia)) {
                System.out.println("Agência criada já existente, será criada uma nova, aguarde...");
            } else {
                conta.setAgencia(agencia);
                ag = true;
            }
        } while (!ag); 
        return ag;
    }

    public static boolean cadastrandoConta(Conta conta, Random random){
        boolean account = false;
        String con;
        do {
            
        } while (!account);

        return account;
    }

    public static void esquecisenha(){
        System.out.println("testando");
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