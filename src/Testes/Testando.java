package Testes;

import java.util.ArrayList;

public class Testando {

    private ArrayList<String> nomes = new ArrayList<>();

    public void setNomes(String completando){
        this.nomes.add(completando);
    }

    public String getNomes(int posicao){
        return this.nomes.get(posicao);
    }

    public void VerificandoNomes(){
        System.out.println("O primeiro nome é: " + getNomes(0));
        System.out.println("O segundo nome é: " + getNomes(1));
        System.out.println("O terceiro nome é: " + getNomes(2));
    }

}
