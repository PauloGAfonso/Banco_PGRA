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

        String [] nomes = {"Paulo", "Gabriel", "Ramos", "Afonso"};
        String [] cpfs = {"49558542814", "32698785210", "65423187990", "35699156478"};
        int[] age = {19, 25, 32, 28};
        String[] senhas = {"5139", "4937", "9236", "1288"};

        for(int i = 0; i < nomes.length; i++){
            titular.setCpfs(cpfs[i]);
            titular.setNomes(i, nomes[i]);
            titular.setCpfs(cpfs[i]);
            titular.setIdade(i, age[i]);
            titular.setSenha(i, senhas[i]);
            conta.setAgencia(i, random);
            conta.setConta(i, random);
            conta.setSaldo(i, 0.0);
        }
        
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
                    access = titular.verificandoSenha(user, senha);
                    if(access){
                        System.out.println("Login realizado com sucesso!");
                    } else {
                        System.out.println("Usuário ou senha incorreto");
                    }
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

        Thread.sleep(5000);
        limpaTela();

        //Usuário logado
        while(access){
            System.out.println("===== MENU BANCO =====");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Extrato");
            System.out.println("6 - Alterar senha");
            System.out.println("0 - Sair");
            int escolha = leitor.nextInt();
            leitor.nextLine();
            limpaTela();
            switch (escolha) {
                case 1:
                    System.out.println("====== Saldo ======");
                    double saldo = conta.getSaldo(user);
                    System.out.println("Seu saldo atual é: " + saldo);
                    System.out.print("Deseja realizar outra operação (S/N): ");
                    String operation = leitor.nextLine();
                    if(operation.equalsIgnoreCase("n") ){
                        access = false;
                    }
                    break;
                case 2:
                    System.out.println("====== Depósito ======");
                    double saldo_atual = conta.getSaldo(user);
                    break;
                case 3:
                    System.out.println("====== Saque ======");
                    break;
                case 4:
                    System.out.println("====== Transferência ======");
                    break;
                case 5:
                    System.out.println("====== Extrato ======");
                    break;
                case 6:
                    System.out.println("====== Troca de Senha =======" );
                    break;
                case 0:
                    System.out.println("Você escolheu sair...");
                    break;
            
                default:
                    break;
            }

            Thread.sleep(5000);
            System.exit(0);

        }

        System.out.println("Obrigado por usar o banco PGRA");
    
        leitor.close();
    }

    public static boolean telaCadastro(Scanner leitor, Titular titular, Conta conta ,Random random) throws Exception {
        boolean titularCadastrado = false;

        do{
            titularCadastrado = cadastrandoUsuario(titular, conta, leitor);
        }while(!titularCadastrado);

        return titularCadastrado;
    }

    public static boolean cadastrandoUsuario(Titular titular, Conta conta , Scanner leitor) throws Exception{
        boolean titularCadastrado = false;
        Random random = new Random();
        do{
            //cadastrando nome
            System.out.print("Por favor, informe seu nome: ");
            String nome = leitor.nextLine();
            System.out.print("informe seu sobrenome: ");
            String sobrenome = leitor.nextLine();
            String nomeCompleto = nome + " " + sobrenome;

            //cadastrando CPF
            boolean verificando = true;
            String cpf;
            do {
                System.out.print("Informe o seu CPF: ");
                cpf = leitor.nextLine();
                verificando = titular.verificandoCpfs(cpf);
                if (verificando){
                    System.out.println("Esse cpf já foi registrado, por favor informe um cpf valido.");
                }
            } while (verificando);
            
            //verificando Idade
            System.out.print("Informe sua idade: ");
            int idade = leitor.nextInt();
            leitor.nextLine(); // consome o enter
            if(idade < 18){
                System.out.println("Você não tem idade permitida para criar uma conta, encerrando o programa...");
            }

            //Definindo senha
            String senha;
            do {
                System.out.print("Digite uma senha de 4 digitos numéricos: ");
                senha = leitor.nextLine();
                if(!senha.matches("\\d{4}")){
                    System.out.println("Entrada inválida! Digite exatamente 4 números.");
                }
            } while(!senha.matches("\\d{4}"));


            
            if(nomeCompleto != null && !nomeCompleto.isEmpty() && cpf.length() == 11 && cpf.matches("\\d{11}") && idade >= 18){
                titular.setCpfs(cpf);
                int posicao = titular.getPosition(cpf);
                titular.setNomes(posicao, nomeCompleto);
                titular.setIdade(posicao, idade);
                titular.setSenha(posicao, senha);
                conta.setAgencia(posicao, random);
                conta.setConta(posicao, random);

                titularCadastrado = true;
                System.out.println("Titular cadastrado corretamente");
                Thread.sleep(5000);
                limpaTela();
            } else {
                System.out.println("Informações preenchidas erroneamente, repite o passo a passo e preencha os campos corretamente.");
                Thread.sleep(4000);
                limpaTela();
            }
        } while(!titularCadastrado);

        return titularCadastrado;
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