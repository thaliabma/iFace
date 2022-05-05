package br.com.ufalp2.ufal.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Comunidade {
    private String titulo;
    private String descricao;
    private String criador;
    private ArrayList<Conta> membros = new ArrayList<>();


    public void visualizarComunidade(){
        System.out.println("Título: "+this.titulo);
        System.out.println("Descrição: "+this.descricao);
        System.out.println("Criador: "+ this.criador);
        System.out.println("Membros: ");
        if (membros != null ){

            for (Conta m:
                    membros) {
                System.out.println("- "+m.getNome());
            }
        }else{
            System.out.println("A comunidade não tem membros.");
        }

    }

    public Comunidade() {
    }

    public void criarComunidade(ArrayList<Conta> usuarios, int usuarioLogado){
        Scanner comu = new Scanner(System.in);

        System.out.println("-------- Criar comunidade --------");
        System.out.print("Título: ");
        String tit = comu.nextLine();
        System.out.println("\n");
        this.titulo = tit;

        System.out.print("Descrição: ");
        String desc = comu.nextLine();
        System.out.println("\n");

        this.descricao = desc;
        this.criador = usuarios.get(usuarioLogado).getNome();
        this.membros.add(usuarios.get(usuarioLogado));
        System.out.print("Comunidade criada! ");
    }


    public Comunidade(String titulo, String  descricao, String criador) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.criador = criador;
    }

    public void adicionarMembros(Conta membro){
        this.membros.add(membro);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public ArrayList<Conta> getMembros() {
        return membros;
    }

    public void setMembros(ArrayList<Conta> membros) {
        this.membros = membros;
    }
}
