import java.util.*;

public class Conta {

    private Titular titular = new Titular();
    private ArrayList<Integer> agencia = new ArrayList<>();
    private ArrayList<Integer> numConta = new ArrayList<>();
    private ArrayList<Double> saldo = new ArrayList<>();

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

    public void sacar(){
        
    }


}
