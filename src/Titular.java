import java.util.*;

public class Titular {

    private ArrayList<String> nomes = new ArrayList<>();
    private ArrayList<String> cpfs = new ArrayList<>();
    private ArrayList<Integer> idades = new ArrayList<>();
    private ArrayList<Integer> id = new ArrayList<>();
    
    
    public String getNomes(String nome) {
        if(nomes.contains(nome)){
            int posicao = nomes.indexOf(nome);
            return nomes.get(posicao);
        } else {
            return null;
        }
    }

    public void setNomes(String nome) {
        nomes.add(nome);
        id.add(nomes.indexOf(nome));
    }

    public String getcpfs(String cpf){
        if(cpfs.contains(cpf)){
            int posicao = cpfs.indexOf(cpf);
            return cpfs.get(posicao);
        } else {
            return null;
        }
    }

    public void setCpfs(String cpf){
        cpfs.add(cpf);
    }
    
    public int getIdade(int idade){
        if(idades.contains(idade)){
            int posicao = idades.indexOf(idade);
            return idades.get(posicao);
        } else {
            return -1;
        }
    }

    public void setIdade(int idade){
        idades.add(idade);
    }

}
