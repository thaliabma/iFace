package Application;

import java.util.ArrayList;
import java.util.Scanner;

public class AdicionarComunidade {

    public void Coms(ArrayList<Conta> usuarios, int index){
        Scanner solicitar = new Scanner(System.in);
        Comunidade com = new Comunidade();
        System.out.println("        NOVA COMUNIDADE        ");
        System.out.print("Nome:");
        String nome = solicitar.next();
        com.nome = nome;
        System.out.print("Descrição: ");
        String desc = solicitar.next();
        com.descricao = desc;
        com.membros.add("Você");
        usuarios.get(index).minhasComunidades.add(com);
        System.out.println("Nova Comunidade criada!");
    }
}
