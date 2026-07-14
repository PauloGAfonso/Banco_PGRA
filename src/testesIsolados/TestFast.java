package testesIsolados;

import java.util.ArrayList;

public class TestFast {

    private ArrayList<String> senha = new ArrayList<>();

    public void addSenha(String senha){
        this.senha.add(senha);
    }

    public int getPosition(String senha){
        return this.senha.indexOf(senha);
    }

    public boolean validandoSenha(int validando, String senha){
        return this.senha.get(validando).equals(senha);
    }

}
