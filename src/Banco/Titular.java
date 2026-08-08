package Banco;

import java.util.*;

public class Titular {

    private final ArrayList<String> nomes = new ArrayList<>();
    private final ArrayList<String> cpfs = new ArrayList<>();
    private ArrayList<Integer> idades = new ArrayList<>();
    private final ArrayList<Integer> id = new ArrayList<>();
    private ArrayList<String> senha = new ArrayList<>();

    public String getNomes(String nome) {
        if (nomes.contains(nome)) {
            int posicao = nomes.indexOf(nome);
            return nomes.get(posicao);
        } else {
            return null;
        }
    }

    public String gettingNome(int usuario, Scanner scanner){
        return this.nomes.get(usuario);
    }

    public String getnomesPosition(int usuario) {
        return nomes.get(usuario);
    }

    public void setNomes(int posicao, String nome) {
        while (this.nomes.size() <= posicao) {
            this.nomes.add(null);
        }
        this.nomes.set(posicao, nome);
    }

    public String getcpfs(String cpf) {
        if (cpfs.contains(cpf)) {
            int posicao = cpfs.indexOf(cpf);
            return cpfs.get(posicao);
        } else {
            return null;
        }
    }

    public boolean verificandoCpfs(String cpf) {
        return cpfs.contains(cpf);
    }

    public int getPosition(String cpf) {
        return this.cpfs.indexOf(cpf);
    }

    public void setCpfs(String cpf) {
        this.cpfs.add(cpf);
        this.id.add(cpfs.indexOf(cpf));
    }

    public int getIdade(int posicao) {
        return this.idades.get(posicao);
    }

    public void setIdade(int posicao, int idade) {
        while (this.idades.size() <= posicao) {
            this.idades.add(null); // cria espaço até o índice
        }
        this.idades.set(posicao, idade);
    }

    public boolean verificandoSenha(int posicao, String senha) {
        if (posicao >= 0 && posicao < this.senha.size()) {
            String password = getSenha(posicao);
            return password != null && password.equals(senha);
        }
        return false; // posição inválida
    }

    private String getSenha(int position) {
        return this.senha.get(position);
    }

    public void changingSenha(String senha, int posicao) {
        System.out.print("Informe a senha atual: ");
    }

    public boolean checkingSenha(int posicao, String senha) {
        String check = getSenha(posicao);
        return check.equalsIgnoreCase(senha);
    }

    public void setSenha(int posicao, String senha) {
        while (this.senha.size() <= posicao) {
            this.senha.add(null); // cria espaço até o índice
        }
        this.senha.set(posicao, senha);
    }

    public int tela_login(Scanner leitor){
        System.out.print("Informe seu cpf: ");
        String login_cpf = leitor.nextLine();
        int user = getPosition(login_cpf);

        System.out.print("Informe sua senha: ");
        String senha = leitor.nextLine();
        boolean check_senha = verificandoSenha(user, senha);

        if(user >= 0 && check_senha){
            return user;
        } else {
            return -1;
        }

    }

    public void verificandoNomes(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < this.nomes.size(); i++){
            System.out.println(i + "º nome: " + gettingNome(i, scanner));
        }

        scanner.nextLine();

        scanner.close();


    }

}
