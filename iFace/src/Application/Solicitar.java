package Application;

import java.util.ArrayList;
import java.util.Scanner;

public class Solicitar {

    public void paraSolicitar(ArrayList<Conta> usuarios, int index){
        System.out.println("------ Solicitações -----");
        Scanner aceitar = new Scanner(System.in);
        if (usuarios.get(index).solicitacoes != null){
            for (int i = 0; i < usuarios.get(index).solicitacoes.size(); i++) {

                System.out.println("{"+(i+1)+"} O usuário " + usuarios.get(index).solicitacoes.get(i)+ " fez um pedido de amizade");
            }
            System.out.println("DESEJA ACEITAR ALGUÉM? [Y/n]");
            String a = aceitar.next();
            if (a.equals("Y")){
                System.out.println("Quem você deseja aceitar?  ");

                System.out.print("--> ");
                int who = aceitar.nextInt();
                System.out.println("Você agora é amigo de "+usuarios.get(index).solicitacoes.get(who - 1));
                usuarios.get(index).amigos.add(usuarios.get(index).solicitacoes.get(who - 1));
                usuarios.get(index).solicitacoes.remove(who - 1);
            }else {
            }

        }else {
            System.out.println("Você não tem solicitações de amizade.");
        }
        }

    }
