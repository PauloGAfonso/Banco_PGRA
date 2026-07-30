package Banco;
import java.util.*;

public class Conta {

    private ArrayList<String> agencia = new ArrayList<>();
    private ArrayList<String> numConta = new ArrayList<>();
    private ArrayList<Double> saldo = new ArrayList<>();
    

    public void setAgencia(int posicao, Random random) throws Exception {
        System.out.println("Estamos criando sua agência... Aguarde uns segundos...");
        Thread.sleep(5000);
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
                Thread.sleep(5000);
                criada = true;
            }
        } while (!criada);
    }

    public boolean verificandoAgencia(String agencia){
        return this.agencia.contains(agencia);
    }

    public void setConta(int posicao, Random random) throws Exception{
        System.out.println("Estamos criando sua conta... Aguarde uns segundos...");
        Thread.sleep(5000);
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
                Thread.sleep(5000);
                criada = true;
            }
        } while (!criada);
    }

    public boolean verificandoConta(String conta){
        return this.numConta.contains(conta);
    }

    public void depositar(double deposito, String usuario, Scanner leitor){
        System.out.println("QUal tipo de deposito você deseja fazer? ");
        System.out.println("Digite 1 para pix");
        System.out.println("Digite 2 para TED");
        int escolha = leitor.nextInt();
        leitor.nextLine();

        switch (escolha) {
            case 1:
                System.out.println("Você escolheu Pix!");
                System.out.println("Informe o nome ou CPF de quem você deseja realizar a transferência");
                break;
            case 2:
                System.out.println("Você escolheu TED!");
                System.out.println("Por padrão, a transferência pode ocorrer em até 3 dias úteis");
            default:
                break;
        }
    
    }

    public void sacar(int posicao, Scanner leitor){
        boolean saque = false;
        do{
            double saldo_atual = getSaldo(posicao);
            System.out.println("informe o valor que deseja sacar: ");
            double valor_saque = leitor.nextDouble();
            leitor.nextLine();
            if(valor_saque > saldo_atual){
                
            }
        } while(!saque);
        
    }

    public Double getSaldo(int posicao){
        return this.saldo.get(posicao);
    }

    public void setSaldo(int posicao, double deposito){
        while(this.saldo.size() <= posicao){
            this.saldo.add(0.0);
        }
        this.saldo.set(posicao, deposito);
    }

    


    

    

    

}
