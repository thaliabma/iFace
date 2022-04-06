package Application;

import java.util.ArrayList;

public class Comunidade {
    public String nome;
    public String descricao;
    public ArrayList<String> membros;

    public void comu(String name, String description, String member){
        this.nome = name;
        this.descricao = description;
        this.membros.add(member);
    }
}
