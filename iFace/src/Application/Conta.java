package Application;

import java.util.ArrayList;

public class Conta{
    public String login;
    public String senha;
    public String usuario;
    public ArrayList<String> amigos = new ArrayList<>();
    public ArrayList<String> solicitacoes = new ArrayList<>();
    public ArrayList<Mensagens> messages = new ArrayList<>();
    public ArrayList<Comunidade> minhasComunidades = new ArrayList<>();

    public Conta(String login,String senha,String usuario){
        this.login = login;
        this.senha = senha;
        this.usuario = usuario;

    }



    @Override
    public String toString() {
        return "Conta{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", usuario='" + usuario + '\'';
    }


}
