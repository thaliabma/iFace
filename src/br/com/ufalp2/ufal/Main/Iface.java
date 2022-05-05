package br.com.ufalp2.ufal.Main;

import br.com.ufalp2.ufal.classes.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Iface {
    public static void main(String[] args) {
        //Coleções necessárias
        List<Conta> contas = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        List<Comunidade> comunidades = new ArrayList<>();

        ArrayList<Conta> usuarios = (ArrayList) contas;

        //Variáveis
            Inicio iface = new Inicio();
            Conta cadastro = new Conta();
            boolean logado = false;
            int usuarioLogado = 0;
            int controleVisualizacaoDePost = 0;

        //CRUD
        CRUD crud = new CRUD();

        //Leitura de dados
        Scanner read = new Scanner(System.in);
        String lerString;
        int lerInt;

        //Inicio
        while (true){
            iface.logoInicio();
            int lerInicio = read.nextInt();
            switch (lerInicio){
                case 1:
                    System.out.println("================== Criar Conta ==================");
                    System.out.print("Email: ");
                    lerString = read.next();
                    String login = lerString;

                    System.out.print("Nome: ");
                    lerString = read.next();
                    String nome = lerString;


                    System.out.print("Senha: ");
                    lerString = read.next();
                    String senha = lerString;


                    Conta usuario = new Conta(login,senha);
                    usuario.setNome(nome);
                    crud.create(usuarios,usuario);
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(usuarios.get(i));
                    }
                    break;
                case 2:
                    System.out.println("================== Login ==================");
                    System.out.print("Email: ");
                    lerString = read.next();
                    String email = lerString;
                    System.out.print("Senha: ");
                    lerString = read.next();
                    String Senha = lerString;

                    Conta usuarioLog = new Conta(email, Senha);

                    for (int i = 0; i < usuarios.size(); i++) {
                        if (usuarios.get(i).getLogin().equals(usuarioLog.getLogin()) && usuarios.get(i).getSenha().equals(usuarioLog.getSenha()) ) {
                            logado = true;
                            usuarioLogado = i;
                            break;
                        } else {
                            if(i == usuarios.size() - 1){
                                System.out.println("Usuário não encontrado!");
                                logado = false;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Essa opção não existe");
                    break;

}           if(logado==true){
                int option = 0;
                while (logado != false){
                    iface.logoConta();
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
                        System.out.println("Sem amigos adicionados");
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

                    iface.menu();
                    option = read.nextInt();
                    switch (option){
                        case 1:
                            usuarios.get(usuarioLogado).editar();
                            break;
                        case 2:
                            System.out.println("Adicionar usuários do Iface: ");
                            for (int i = 0; i < usuarios.size(); i++) {
                                if (i == usuarioLogado){
                                    System.out.println("{Você} "+ usuarios.get(i).getNome());

                                }else{
                                    System.out.println("{"+(i+1)+"} "+ usuarios.get(i).getNome());
                                }
                            }
                            System.out.print("Adicionar ~> ");
                            int ad = read.nextInt();
                            System.out.println(usuarios.get(ad - 1));
                            usuarios.get(ad - 1).receberSolicitacao(usuarios.get(usuarioLogado), usuarios, usuarioLogado);
                            System.out.println("Sua solicitação foi enviada para "+usuarios.get(ad-1).getNome());
                            break;
                        case 3:
                            if (usuarios.get(usuarioLogado).getSolicitacoes() != null && usuarios.get(usuarioLogado).getSolicitacoes().size() != 0 ){
                                System.out.println("Solicitações: ");

                                for (int i = 0; i < usuarios.get(usuarioLogado).getSolicitacoes().size(); i++) {
                                    System.out.println("{"+(i+1)+"} "+ usuarios.get(usuarioLogado).getSolicitacoes().get(i).getNome());

                                }
                                System.out.println("----------------------");
                                System.out.println("Aceitar solicitação ~> ");
                                int sol = read.nextInt();
                                int amigo = 0;
                                for (int i = 0; i < usuarios.size(); i++) {
                                    if (usuarios.get(usuarioLogado).getSolicitacoes().get(sol-1).equals(usuarios.get(i))){
                                        amigo = i;
                                        break;
                                    }
                                }
                                usuarios.get(usuarioLogado).aceitarSolicitacao(sol-1, usuarios,amigo);
                                usuarios.get(amigo).getAmigos().add(usuarios.get(usuarioLogado));


                            }else {
                                System.out.println("Você não tem solicitações.");
                            }
                            break;
                        case 4:
                            MensagemPrivada message = new MensagemPrivada();

                            message.menuMensagens(usuarios, usuarioLogado);
                            break;
                        case 5:
                            System.out.println("-------- Comunidades -------");
                            System.out.println("{1} Criar comunidade");
                            System.out.println("{2} Participar de comunidade");
                            System.out.println("{3} Sair");
                            int com = read.nextInt();
                            switch (com){
                                case 1:
                                   Comunidade comu = new Comunidade();
                                   comu.criarComunidade(usuarios, usuarioLogado);
                                   comunidades.add(comu);
                                   usuarios.get(usuarioLogado).getComunidades().add(comu);
                                    break;
                                case 2:
                                    if (comunidades != null && comunidades.size() != 0){

                                        for (int i = 0; i < comunidades.size(); i++) {
                                            System.out.println("{"+(i+1)+"} " + comunidades.get(i).getTitulo());
                                        }
                                        System.out.println("Participar da comunidade ~> ");
                                        int comunidade = read.nextInt();
                                        //Colocando usuario na lista de comunidades geral
                                        comunidades.get(comunidade - 1).getMembros().add(usuarios.get(usuarioLogado));
                                        //Colocando comunidades na lista de comuni do usuario
                                        usuarios.get(usuarioLogado).getComunidades().add(comunidades.get(comunidade - 1));
                                        System.out.println("Você está participando de uma nova comunidade!");
                                    }else{
                                        System.out.println("Sem comunidades no Iface.");
                                    }
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                                    break;

                            }
                            break;
                        case 6:
                            usuarios.get(usuarioLogado).visualizarConta();
                            break;
                        case 7:
                            Post postar = new Post();
                            postar.postar(usuarios.get(usuarioLogado));
                            //System.out.println("Quem pode visualizar sua mensagem?");
                            //System.out.println("{1} Amigos");
                            //System.out.println("{2} Geral");
                            //controleVisualizacaoDePost = read.nextInt();
                            posts.add(postar);
                            break;
                        case 8:
                            System.out.println("DESEJA EXCLUIR SUA CONTA? (y/n)");
                            String in = read.next();
                            if (in.equals("y")){
                                usuarios.remove(usuarioLogado);
                                System.out.println("CONTA EXCLUÍDA");
                                logado = false;
                            }
                            else{
                                break;
                            }
                            break;
                        case 9:
                            logado = false;
                            break;
                    }
                }
            }

    }
}
}
