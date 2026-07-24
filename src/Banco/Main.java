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
        boolean cadastrado = false;
        int user = -1;
        
       do{
            System.out.println("Bem vindo ao Banco PGRA!");
            System.out.println("Digite 1 para acessar sua conta!");
            System.out.println("Digite 2 para cadastrar sua conta.");
            System.out.println("Digite 3 para sair!");
            System.out.print("R: ");
            int resposta = leitor.nextInt();
            leitor.nextLine();
            switch (resposta) {
                case 1:
                    System.out.print("Informe seu CPF: ");
                    String cpf = leitor.nextLine();
                    user = titular.getPosition(cpf);

                    System.out.print("informe sua senha: ");
                    String senha = leitor.nextLine();

                    break;
                case 2:
                    cadastrado = telaCadastro(leitor, titular, conta, random);
                    if(cadastrado){
                        System.out.println("Usuário cadastrado!");
                        Thread.sleep(5000);
                        limpaTela();
                    }
                    break;
                case 3:
                    System.out.println("Você escolheu sair...");
                    break;
                default:
                    System.out.println("Opção inexistente, encerrando o programa");
                    System.exit(1);
                    break;
            }
        } while (!access);

        //pós logado
        if(access){
            do {
                System.out.println("Você logou bem vindo usuário: " + titular.getnomesPosition(user));
                System.exit(0);
            } while (true);
        }

        System.out.println("Obrigado por usar o banco PGRA");
    
        leitor.close();
    }

    //Usuário logando
    public static boolean telaLogin(String cpf, String senha, Titular titular, Conta conta){
        boolean senhaVerificada = false;
        boolean check_cpf = titular.verificandoCpfs(cpf);
        int posicao = titular.getPosition(cpf);

        String check_senha = titular.getSenha(posicao);

        if(check_cpf && check_senha.equals(senha)){
            return !senhaVerificada;
        } else {
            return senhaVerificada;
        }

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

        return titularCadastrado && agencia && account;
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

    public static boolean cadastrandoAgencia(Conta conta, Random random) throws Exception{
        System.out.println("Estamos criando sua agência... Aguarde uns segundos...");
        Thread.sleep(5000);
        String agencia;
        boolean ag = false;
        do {
            int numero = random.nextInt(10000);
            int digito = random.nextInt(10);
            agencia = String.format("%04d-%d", numero, digito);
            if (conta.verificandoAgencia(agencia)) {
                System.out.println("Agência criada já existente, será criada uma nova, aguarde...");
            } else {
                System.out.println("Agencia criada com sucesso!");
                System.out.println("Agencia: " + agencia);
                conta.setAgencia(agencia);
                Thread.sleep(5000);
                ag = true;
            }
        } while (!ag); 
        return ag;
    }

    public static boolean cadastrandoConta(Conta conta, Random random) throws Exception{
        boolean account = false;
        String con;
        do {
            int numero = random.nextInt(10000000);
            int digito = random.nextInt(10);
            con = String.format("%07d-%d", numero, digito);
            if(conta.verificandoConta(con)){
                System.out.println("número da conta já existente, será criada uma nova, aguarde...");
            } else {
                System.out.println("Conta criada com sucesso!");
                System.out.println("Conta: " + con);
                conta.setConta(con);
                Thread.sleep(5000);
                account  = true;
            }
        } while (!account);
        return account;
    }


    public static void esquecisenha(Scanner leitor, Titular titular, Conta conta){
        System.out.print("Por favor, informe seu CPF: ");
        String cpf = leitor.nextLine();
        String checking_cpf = titular.getcpfs(cpf);
        if(checking_cpf != null){
            String nova_senha;
            do {
                System.out.print("Informe a nova senha que deseja criar: ");
                nova_senha = leitor.nextLine();
                if (!nova_senha.matches("\\d{4}")) {
                    System.out.println("Senha inválida, insira apenas 4 números.");
                }
            } while (!nova_senha.matches("\\d{4}"));

            int posicao = titular.getPosition(checking_cpf);
            titular.changingSenha(nova_senha, posicao);
        }
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