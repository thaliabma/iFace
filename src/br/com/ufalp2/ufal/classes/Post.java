package br.com.ufalp2.ufal.classes;

import java.util.Calendar;
import java.util.Scanner;

public class Post extends Mensagem{


    public void postar(Conta remetente){
        System.out.println("-------- Novo Post (Escreva algo para o seu feed de posts) --------");
        Scanner message = new  Scanner(System.in);
        System.out.print("~> ");
        String mess = message.nextLine();
        System.out.println("\n");
        super.corpo = mess;
        super.remetente = remetente;
    }
    public void postagem(){
        Calendar data = Calendar.getInstance();
        System.out.println("Postado em "+data.getTime());
        System.out.println("Por: "+super.remetente.getNome());
        System.out.println("'"+super.corpo+"'");
    }

    public Post() {
    }

    public Post(String corpo, Conta remetente) {
        super(corpo, remetente);

    }


}
