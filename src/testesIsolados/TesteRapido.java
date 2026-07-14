package testesIsolados;

import java.util.ArrayList;
import java.util.Scanner;

public class TesteRapido {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TestFast testing = new TestFast();

        testing.addSenha("4321");

        System.out.print("informe a senha: ");
        String pass = scan.nextLine();

        int posicao = testing.getPosition(pass);
        if(posicao == -1){
            System.out.println("Senha incorreta!!!");
            System.exit(0);
        }

        boolean validado = testing.validandoSenha(posicao, pass);
        if (validado) {
            System.out.println("Senha inserida corretamente");
        } else {
            System.out.println("Errou seu tapado");
        }

        scan.close();



        
        
    }

}
