package br.com.ufalp2.ufal.classes;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public void logoInicio(){

        System.out.println("   ▉▉▉▉▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉    ▉▉▉▉▉    ▉▉▉▉▉▉▉▉   ");
        System.out.println("█  ▉▉            ▉       ▉   ▉         ▉▉          ");
        System.out.println("█  ▉▉            ▉       ▉   ▉         ▉▉         ");
        System.out.println("█  ▉▉▉▉▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉   ▉         ▉▉▉▉▉▉▉▉  ");
        System.out.println("█  ▉▉            ▉       ▉   ▉         ▉▉          ");
        System.out.println("█  ▉▉            ▉       ▉   ▉         ▉▉          ");
        System.out.println("█  ▉▉            ▉       ▉    ▉▉▉▉▉    ▉▉▉▉▉▉▉▉  ");


        System.out.println("================== INÍCIO ==================");
        System.out.println("\nPress:   {1} CRIAR CONTA  --   {2} L0GIN");

        System.out.print("~> ");
    }

    public void logoConta(){
        System.out.println("   ▉▉▉▉▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉    ▉▉▉▉▉    ▉▉▉▉▉▉▉▉   ");
        System.out.println("█  ▉▉            ▉       ▉   ▉         ▉▉          ");
        System.out.println("█  ▉▉            ▉       ▉   ▉         ▉▉         ");
        System.out.println("█  ▉▉▉▉▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉   ▉         ▉▉▉▉▉▉▉▉  ");
        System.out.println("█  ▉▉            ▉       ▉   ▉         ▉▉          ");
        System.out.println("█  ▉▉            ▉       ▉   ▉         ▉▉          ");
        System.out.println("█  ▉▉            ▉       ▉    ▉▉▉▉▉    ▉▉▉▉▉▉▉▉  ");

    }

    public void menuPrincipal() {
        System.out.println("{1} Editar Perfil");
        System.out.println("{2} Adicionar Amigos");
        System.out.println("{3} Solicitações");
        System.out.println("{4} Mensagens");
        System.out.println("{5} Comunidade");
        System.out.println("{6} Recuperar informações");
        System.out.println("{7} Novo Post");
        System.out.println("{8} Remover conta");
        System.out.println("{9} Sair");
        System.out.print("~> ");

    }
    public void boasVindas(ArrayList <Conta> usuarios, int usuarioLogado, List<Post> posts,List<Comunidade> comunidades){
        this.logoConta();
        System.out.println("\n================== Bem vindo(a): "+usuarios.get(usuarioLogado).getNome()+" ==================");
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("                                            [FEED]");
        if (posts != null && posts.size() != 0){
            for (int i = 0; i < posts.size(); i++) {
                posts.get(i).postagem();
                System.out.println("--------------------------------");

            }
        }else{
            System.out.println("Sem postagens no momento");
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("                                          [AMIGOS]");
        if (usuarios.get(usuarioLogado).getAmigos() != null && usuarios.get(usuarioLogado).getAmigos().size() != 0 ){

            for (int i = 0; i < usuarios.get(usuarioLogado).getAmigos().size(); i++) {
                System.out.println("-"+usuarios.get(usuarioLogado).getAmigos().get(i).getNome());
            }
        }else{
            System.out.println("Sem amigos adicionados.");
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("                                     [COMUNIDADES]");
        if (comunidades != null && comunidades.size() != 0){

            for (int i = 0; i < comunidades.size(); i++) {
                comunidades.get(i).visualizarComunidade();
                System.out.println("--------------------------------");

            }
        }else{
            System.out.println("Sem comunidades no Iface.");
        }

        System.out.println("\n========================================");
        this.menuPrincipal();
    }
    public void MenuComunidade(){
        System.out.println("-------- Comunidades -------");
        System.out.println("{1} Criar comunidade");
        System.out.println("{2} Participar de comunidade");
        System.out.println("{3} Sair");
        System.out.print("~> ");
    }

}
