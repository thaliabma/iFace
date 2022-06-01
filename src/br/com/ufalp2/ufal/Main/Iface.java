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
            int lerInicio = 0;
            try{

                lerInicio = Integer.parseInt(read.nextLine());

            }catch (NumberFormatException e){
                System.out.println("Inválido!");
            }

            switch (lerInicio){
                case 1:
                    System.out.println("================== Criar Conta ==================");
                    while (true){
                        try{
                            System.out.print("Email: ");
                            String login = read.nextLine();

                            if (!login.contains("@")){
                                throw new NaoEhEmailException(login);
                            }

                            System.out.print("Nome: ");
                            lerString = read.nextLine();
                            String nome = lerString;

                            if (!nome.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\s]+$")){
                                throw new SomenteLetrasException(nome);
                            }

                            System.out.print("Senha: ");
                            lerString = read.nextLine();
                            String senha = lerString;

                            Conta usuario = new Conta(login,senha);
                            usuario.setNome(nome);
                            crud.create(usuarios,usuario);
                            System.out.println("\n      Conta criada! Vá para login\n");

                            break;

                        } catch (NaoEhEmailException e) {
                            System.out.println("----------------------------");
                            System.out.println("Insira um e-mail válido!");
                            System.out.println("----------------------------");

                        } catch (SomenteLetrasException e) {
                            System.out.println("----------------------------");
                            System.out.println("Insira um nome válido!");
                            System.out.println("----------------------------");

                        }
                    }
                    break;
                case 2:
                    System.out.println("================== Login ==================");

                    System.out.print("Email: ");
                    lerString = read.nextLine();
                    String email = lerString;

                    System.out.print("Senha: ");
                    lerString = read.nextLine();
                    String Senha = lerString;

                    Conta usuarioLog = new Conta(email, Senha);

                    for (int i = 0; i < usuarios.size(); i++) {
                        if (usuarios.get(i).getLogin().equals(usuarioLog.getLogin()) && usuarios.get(i).getSenha().equals(usuarioLog.getSenha()) ) {
                            logado = true;
                            usuarioLogado = i;
                            break;
                        } else {
                            if(i == usuarios.size() - 1){
                                System.out.println("\nUsuário não encontrado!\n");
                                logado = false;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("\nEssa opção não existe\n");
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

                    iface.menu();

                    try
                    {
                        option = Integer.parseInt(read.nextLine());
                        if (option == 0 || option > 9){
                            throw new NaoEhOpcaoException(option);
                        }
                    }
                    catch(NumberFormatException | NaoEhOpcaoException e)
                    {
                        System.out.println("\nOpção inválida!\n");
                    }

                    switch (option){
                        case 1:
                            usuarios.get(usuarioLogado).editar();
                            break;
                        case 2:
                            System.out.println("Usuários do Iface: ");
                            if(usuarios.size() <= 1){
                                System.out.println("\nSó existe você no Iface :( \n");
                                break;

                            }else{
                                for (int i = 0; i < usuarios.size(); i++) {
                                    if (i == usuarioLogado){
                                        continue;

                                    }
                                    else{
                                        System.out.println("{"+(i)+"} "+ usuarios.get(i).getNome());
                                    }
                                }
                            }

                            System.out.print("Adicionar ~> ");
                            int ad = 0;

                            try
                            {
                                ad = Integer.parseInt(read.nextLine());
                                usuarios.get(ad).receberSolicitacao(usuarios.get(usuarioLogado), usuarios, usuarioLogado);
                                System.out.println("\n Sua solicitação foi enviada para "+usuarios.get(ad).getNome() +"\n");
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("\nOpção inválida!\n");

                            }catch(IndexOutOfBoundsException i){
                                System.out.println("\nOpção não existe!\n");
                            }finally{
                                break;
                            }

                        case 3:
                            if (usuarios.get(usuarioLogado).getSolicitacoes() != null && usuarios.get(usuarioLogado).getSolicitacoes().size() != 0 ){
                                System.out.println("Solicitações: ");

                                for (int i = 0; i < usuarios.get(usuarioLogado).getSolicitacoes().size(); i++) {
                                    System.out.println("{"+(i+1)+"} "+ usuarios.get(usuarioLogado).getSolicitacoes().get(i).getNome());

                                }
                                System.out.println("----------------------");
                                System.out.print("Aceitar solicitação ~> ");
                                int sol = 0;
                                try
                                {
                                    sol = Integer.parseInt(read.nextLine());
                                    int amigo = 0;

                                    for (int i = 0; i < usuarios.size(); i++) {
                                        if (usuarios.get(usuarioLogado).getSolicitacoes().get(sol-1).equals(usuarios.get(i))){
                                            amigo = i;
                                            break;
                                        }
                                    }
                                    usuarios.get(usuarioLogado).aceitarSolicitacao(sol-1, usuarios,amigo);
                                    usuarios.get(amigo).getAmigos().add(usuarios.get(usuarioLogado));
                                }
                                catch(NumberFormatException e)
                                {
                                    System.out.println("\nOpção inválida!\n");

                                }catch(IndexOutOfBoundsException i){
                                    System.out.println("\nOpção não existe!\n");
                                }finally{
                                    break;
                                }
                            }else {
                                System.out.println("\nVocê não tem solicitações.\n");
                                break;
                            }
                        case 4:
                            MensagemPrivada message = new MensagemPrivada();

                            message.menuMensagens(usuarios, usuarioLogado);
                            break;
                        case 5:
                            int com = 0;
                            try{

                                System.out.println("-------- Comunidades -------");
                                System.out.println("{1} Criar comunidade");
                                System.out.println("{2} Participar de comunidade");
                                System.out.println("{3} Sair");
                                System.out.print("~> ");
                                com = Integer.parseInt(read.nextLine());
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
                                            System.out.print("Participar da comunidade ~> ");
                                            int comunidade = 0;
                                            try{

                                                comunidade = Integer.parseInt(read.nextLine());
                                                //Colocando usuario na lista de comunidades geral
                                                comunidades.get(comunidade - 1).getMembros().add(usuarios.get(usuarioLogado));
                                                //Colocando comunidades na lista de comuni do usuario
                                                usuarios.get(usuarioLogado).getComunidades().add(comunidades.get(comunidade - 1));
                                                System.out.println("Você está participando de uma nova comunidade!");

                                            }catch (NumberFormatException e){
                                                System.out.println("Opção Inválida!");
                                            }catch(IndexOutOfBoundsException i){
                                                System.out.println("\nOpção não existe!\n");
                                            }
                                        }else{
                                            System.out.println("Sem comunidades no Iface.");
                                        }
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                            }catch(NumberFormatException e){
                                System.out.println("\nOpção inválida!!!\n");
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
                            String in = read.nextLine();
                            if (in.equals("y")){
                                usuarios.remove(usuarioLogado);
                                System.out.println("CONTA EXCLUÍDA");
                                logado = false;
                            }
                            else if(in.equals("n")){
                                System.out.println("Cancelando operação");
                                break;
                            }
                            else{
                                System.out.println("Opção inválida");
                                break;
                            }
                        case 9:
                            logado = false;
                            break;
                    }
                }
            }

    }
}
}
