package Banco;

import java.util.*;

public class Conta {

    private ArrayList<String> agencia = new ArrayList<>();
    private ArrayList<String> numConta = new ArrayList<>();
    private ArrayList<Double> saldo = new ArrayList<>();

    public void setAgencia(int posicao, Random random) throws Exception {
        System.out.println("Estamos criando sua agência... Aguarde uns segundos...");
        // Thread.sleep(5000);
        String agencia;
        boolean criada = false;
        do {
            int numero = random.nextInt(10000);
            int digito = random.nextInt(10);
            agencia = String.format("%04d-%d", numero, digito);
            if (this.agencia.contains(agencia)) {
                System.out.println("Agência já existente, criando uma nova...");
            } else {
                System.out.println("Agência criada com sucesso!");
                System.out.println("Agência: " + agencia);
                while (this.agencia.size() <= posicao) {
                    this.agencia.add(null);
                }
                this.agencia.set(posicao, agencia); // já salva na lista
                // Thread.sleep(5000);
                criada = true;
            }
        } while (!criada);
    }

    public boolean verificandoAgencia(String agencia) {
        return this.agencia.contains(agencia);
    }

    public void setConta(int posicao, Random random) throws Exception {
        System.out.println("Estamos criando sua conta... Aguarde uns segundos...");
        // Thread.sleep(5000);
        String conta;
        boolean criada = false;
        do {
            int numero = random.nextInt(10000000);
            int digito = random.nextInt(10);
            conta = String.format("%07d-%d", numero, digito);
            if (this.numConta.contains(conta)) {
                System.out.println("Conta já existente, criando uma nova...");
            } else {
                System.out.println("Conta criada com sucesso!");
                System.out.println("Conta: " + conta);
                while (this.numConta.size() <= posicao) {
                    this.numConta.add(null);
                }
                this.numConta.set(posicao, conta); // já salva na lista
                // Thread.sleep(5000);
                criada = true;
            }
        } while (!criada);
    }

    public boolean verificandoConta(String conta) {
        return this.numConta.contains(conta);
    }

    public void sacar(int posicao, Scanner leitor) throws Exception {
        boolean continuar = true;
        do {
            double saldo_atual = getSaldo(posicao);
            System.out.print("informe o valor que deseja sacar: ");
            double valor_saque = leitor.nextDouble();
            leitor.nextLine();
            if (valor_saque > saldo_atual) {
                System.out.println("Saldo insuficiente para realizar essa operação!");
            } else if (valor_saque <= 0) {
                System.out.println("Você não pode realizar um saque menor ou igual a zero.");
            } else {
                saldo_atual = saldo_atual - valor_saque;
                System.out.println("Saque do valor de " + valor_saque + " foi realizado com sucesso!");
                System.out.println("Saldo Atual: " + saldo_atual);
                setSaldo(posicao, saldo_atual);
                continuar = false;
            }

            if (continuar) {
                System.out.print("Deseja continuar(s/n): ");
                String resposta = leitor.nextLine();
                if (resposta.equalsIgnoreCase("n")) {
                    continuar = false;
                }
            }
        } while (continuar);

    }

    public Double getSaldo(int posicao) {
        return this.saldo.get(posicao);
    }

    public void setSaldo(int posicao, double deposito) {
        while (this.saldo.size() <= posicao) {
            this.saldo.add(0.0);
        }
        this.saldo.set(posicao, deposito);
    }

    public void transferência(int user, Scanner leitor) {
        System.out.print("Informe o CPF da conta que deseja realizar a transfêrencia: ");
    }

    public void deposito(int usuario, Scanner leitor) {
        boolean depositado = false;
        do {
            System.out.print("Informe a quantidade que deseja depositar: ");
            String valor = leitor.nextLine();

            try{
                Double novo_saldo = Double.parseDouble(valor);
                double saldo_antigo = this.saldo.get(usuario);
                Double deposito = novo_saldo + saldo_antigo;
                if (novo_saldo > 0) {
                    System.out.println("Um depósito no valor de R$ " + valor + " foi feito com sucesso!");
                    this.saldo.set(usuario, deposito);
                    depositado = true;
                } else {
                    System.out.println(" informe um número válido");
                }
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida! Digite um numero");
            }
        } while (!depositado);

    }

    public void consultarSaldo(int usuario, Scanner leitor, Titular titular) {
        System.out.println("Usuário: " + titular.gettingNome(usuario, leitor));
        System.out.println();
        System.out.println("Seu saldo atual é: " + getSaldo(usuario));
    }

    public int menu_principal(Scanner leitor){
        System.out.println("Bem vindo ao Banco PGRA!");
        System.out.println("Digite 1 para acessar sua conta!");
        System.out.println("Digite 2 para cadastrar uma conta.");
        System.out.println("Digite 3 para sair!");
        System.out.print("R: ");
        int resposta = leitor.nextInt();
        leitor.nextLine();

        return resposta;
    }

}
