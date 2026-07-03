package testesIsolados;

import java.util.ArrayList;
import java.util.Scanner;

public class testando {

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        ArrayList<String> nome = new ArrayList<>();
        ArrayList<Integer> indice = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        

        // System.out.println(test.size());
        // System.out.println(nome.size());
        // nome.add("Paulo");
        // System.out.println("tamanho do nome " + nome.size());
        // test.add(nome.size());
        // System.out.println(test);

        String name = "Paulo";
        String sobreNome = "Afonso";
        nome.add(name + " " + sobreNome);
        System.out.println(nome);
        name = "Gabriel";
        sobreNome = "Ramos";
        nome.add(name + " " + sobreNome);
        System.out.println(nome);

        System.out.println(nome.indexOf("Paulo Afonso"));
        indice.add(nome.indexOf("Gabriel Ramos"));
        indice.add(nome.indexOf("Paulo Afonso"));

        System.out.println(indice);

        System.out.println("nesse momento existem " + nome.size() + " usuários cadastrados.");
        System.out.print("informe o número de ID que você deseja trazer: ");
        int id = scan.nextInt();
        scan.nextLine();
        id-=1;
        System.out.print("Usuário: " + nome.get(id));
        
        


        

    }

}
