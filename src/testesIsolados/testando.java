package testesIsolados;

import java.util.ArrayList;
import java.util.Scanner;

public class testando {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        System.out.print("Por favor, informe seu nome: ");
        String nome = leitor.nextLine();
        System.out.print("informe seu sobrenome: ");
        String sobrenome = leitor.nextLine();

        String nomeCompleto = nome + " " + sobrenome;

        System.out.println(nomeCompleto);
        
        leitor.close();
    }



}
