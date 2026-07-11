package testesIsolados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class testando {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        ArrayList<String> login = new ArrayList<>(Arrays.asList("49558542814", "49658342852"));
        ArrayList<String> senha = new ArrayList<>(Arrays.asList("0123", "3210"));


        System.out.println("informe o login: ");
        String user = leitor.nextLine();
        int validando = getPosition(user, login);
        if(validando == -1){
            System.out.println("Usuário inexistente");
        }


        System.out.print("informe a senha: ");
        String password = leitor.nextLine();
        if(senha.get(validando).equals(password)){
            System.out.println("login realizado com sucesso.");
        } else {
            System.out.println("usuário ou Senha incorreta");
        }



        leitor.close();
    }

    public static int getPosition(String user, ArrayList<String> login){
        return login.indexOf(user);
    }



}
