package Banco;
import java.util.*;

public class Titular {

    private final ArrayList<String> nomes = new ArrayList<>();
    private final ArrayList<String> cpfs = new ArrayList<>();
    private ArrayList<Integer> idades = new ArrayList<>();
    private final ArrayList<Integer> id = new ArrayList<>();
    private ArrayList<String> senha = new ArrayList<>();
    
    
    public String getNomes(String nome) {
        if(nomes.contains(nome)){
            int posicao = nomes.indexOf(nome);
            return nomes.get(posicao);
        } else {
            return null;
        }
    }

    public String getnomesPosition(int usuario){
        return nomes.get(usuario);
    }

    public void setNomes(int posicao, String nome) {
        while(this.nomes.size() <= posicao){
            this.nomes.add(null);
        }
        this.nomes.set(posicao, nome);
        id.add(this.nomes.indexOf(nome));
    }

    public String getcpfs(String cpf){
        if(cpfs.contains(cpf)){
            int posicao = cpfs.indexOf(cpf);
            return cpfs.get(posicao);
        } else {
            return null;
        }
    }

    public boolean verificandoCpfs(String cpf){
        return cpfs.contains(cpf);
    }

    public int getPosition(String cpf){
        return this.cpfs.indexOf(cpf);
    }

    public void setCpfs(String cpf){
        this.cpfs.add(cpf);
        this.id.add(cpfs.indexOf(cpf));
    }
    
    public int getIdade(int idade){
        if(idades.contains(idade)){
            int posicao = idades.indexOf(idade);
            return idades.get(posicao);
        } else {
            return -1;
        }
    }

    public void setIdade(int posicao, int idade){
        while (this.idades.size() <= posicao) {
            this.idades.add(null); // cria espaço até o índice
        }
        this.idades.set(posicao, idade);
    }

    public boolean verificandoSenha(int posicao, String senha){
        if (posicao >= 0 && posicao < this.senha.size()) {
            String password = getSenha(posicao);
            return password.equals(senha);
        }
        return false; // posição inválida
    }

    private String getSenha(int position){
        return this.senha.get(position);
    }
    
    public void changingSenha(String senha, int posicao){
        this.senha.set(posicao, senha);
    }

    public boolean checkingSenha(int posicao, String senha){
        String check = getSenha(posicao);
        return check.equalsIgnoreCase(senha);
    }

    public void setSenha(int posicao, String senha){
        while(this.senha.size() <= posicao) {
            this.senha.add(null); // cria espaço até o índice
        }
        this.senha.set(posicao, senha);
    }

}
