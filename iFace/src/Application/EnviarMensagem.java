package Application;

import java.util.ArrayList;
import java.util.Scanner;

public class EnviarMensagem {
    public void Enviar(ArrayList<Conta> usuarios, int index){
    Scanner aceitar = new Scanner(System.in);
        ArrayList<Conta> usuarioAdicionar = new ArrayList<>();
        int destinatario = 0;
        System.out.println("Usuários ativos: ");
        for (int i = 0; i < usuarios.size(); i++) {
            if (i != index){
                usuarioAdicionar.add(usuarios.get(i));
            }
        }
        for (int i = 0; i < usuarioAdicionar.size(); i++) {
            System.out.println("["+(i+1)+"]" + usuarioAdicionar.get(i).usuario);
        }
        System.out.println("DESEJA ENVIAR MENSAGEM? [Y/n] ");
        String a = aceitar.next();
        if (a.equals("Y")) {
            System.out.println("Para quem você deseja enviar mensagem?  ");
            System.out.print("--> ");
            int who = aceitar.nextInt();
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).usuario.equals(usuarioAdicionar.get(who-1).usuario)){
                    destinatario = i;
                    break;
                }
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("            #### " +usuarios.get(destinatario).usuario + " ####" );
            System.out.print(">> ");
            String messag = aceitar.next();
            Mensagens adicionar = new Mensagens();
            adicionar.Men(usuarios.get(destinatario).usuario,messag);
//            adicionar.receptor = usuarios.get(destinatario).usuario;
//            adicionar.mensagens.add(messag);
//            usuarios.get(destinatario).messages.add(adicionar);
            System.out.print("Mensagem enviada com sucesso! ");
        }
    }
}
