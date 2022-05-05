package br.com.ufalp2.ufal.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class MensagemPrivada extends Mensagem{
    private Conta destino;

    public MensagemPrivada() {

    }

    @Override
    public String toString() {
        return "- '" + corpo + "'\n" +"---------------------------"+
                //"Enviado por:" + super.remetente.getNome() +
                '\n';
    }

    public void visualizarMensagens(){
        System.out.println("- "+super.corpo);
        //System.out.println("Enviado por "+super.remetente);
    }

    public void enviarMensagem(Conta destino, ArrayList<Conta> usuarios, int destinoIndex, Conta remetente){
        this.destino = destino;
        Scanner ler = new Scanner(System.in);
        System.out.println("---------------- Mensagem para " + this.destino.getNome());
        System.out.print("~> ");
        String message = ler.nextLine();
        System.out.print("\n");

        MensagemPrivada enviar = new MensagemPrivada(message, remetente, this.destino);

        usuarios.get(destinoIndex).getMensagens().add(enviar);
        System.out.println("Mensagem enviada com sucesso!");
    }

    public void menuMensagens( ArrayList<Conta> usuarios, int usuarioLogado){
        Scanner ler = new Scanner(System.in);

        System.out.println("-------------- Mensagens ------------");
        System.out.println("{1} Enviar mensagem");
        System.out.println("{2} Visualizar mensagens");
        System.out.println("{3} Sair");

        int op = ler.nextInt();

        switch (op){
            case 1:
                System.out.println("-------------- Chat --------------");
                System.out.println("Usuários que estão na plataforma:");
                for (int i = 0; i < usuarios.size(); i++) {
                    if (i == usuarioLogado){
                        System.out.println("{Você} "+ usuarios.get(i).getNome());
                    }else{

                    System.out.println("{"+(i+1)+"} "+ usuarios.get(i).getNome());
                    }
                }
                System.out.print("Falar com ~> ");
                int chat = ler.nextInt();
                this.enviarMensagem(usuarios.get(chat - 1), usuarios, chat - 1,usuarios.get(usuarioLogado));
                break;
            case 2:
                if (usuarios.get(usuarioLogado).getMensagens() != null && usuarios.get(usuarioLogado).getMensagens().size() != 0){

                    for (int i = 0; i < usuarios.get(usuarioLogado).getMensagens().size(); i++) {

                        System.out.println("-" +usuarios.get(usuarioLogado).getMensagens().get(i).corpo);
                        System.out.println("Enviado por: " +usuarios.get(usuarioLogado).getMensagens().get(i).remetente.getNome());
                        System.out.println("--------------------------------------");
                    }
                }else{
                    System.out.println("Você não tem mensagens!");
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Essa opcao não existe!");
                break;
        }
    }

    public Conta getDestino() {
        return destino;
    }

    public void setDestino(Conta destino) {
        this.destino = destino;
    }

    public MensagemPrivada(String corpo, Conta remetente, Conta destino) {
        super(corpo, remetente);
        this.destino = destino;
    }



}
