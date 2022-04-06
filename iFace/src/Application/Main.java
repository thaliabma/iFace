package Application;

import Application.Conta;
import Application.Interface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Variáveis Importantes
        Scanner Login = new Scanner(System.in);
        boolean logado = false;
        int index = 0;
        int opcaoLogado = 0;
        int opcaoEditar;
        Scanner edit = new Scanner(System.in);
        ArrayList<String> Post = new ArrayList<>();
        Date now = new Date();
        Interface face = new Interface();
        face.Login();
        System.out.println("\n{1} CRIAR CONTA  --   {2} L0GIN");

        System.out.print("--> ");
        int enter = Login.nextInt();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        ArrayList<Conta> usuarios = new ArrayList<>();


        while (true) {
            if (logado == false){
                switch (enter) {
                    case 1:
                        Scanner entrar = new Scanner(System.in);

                        System.out.print("E-mail: ");
                        String loginLogar = entrar.next();

                        System.out.print("Senha: ");
                        String senhaLogar = entrar.next();

                        System.out.print("Nome: ");
                        String usuarioLogar = entrar.next();

                        Conta usuarioNovo = new Conta(loginLogar, senhaLogar, usuarioLogar);

                        usuarios.add(usuarioNovo);

                        break;

                    case 2:
                        Scanner logar = new Scanner(System.in);
                        System.out.println("--------- iFace --------- ");
                        System.out.println("    - Entrar -    ");

                        System.out.println("Login: ");
                        String loginEntrar = logar.next();

                        System.out.println("Senha: ");
                        String senhaEntrar = logar.next();

                        Conta usuarioCadastrado = new Conta(loginEntrar, senhaEntrar, null);
                        for (int i = 0; i < usuarios.size(); i++) {
                            if (usuarios.get(i).login.equals(loginEntrar)) {
                                logado = true;
                                index = i;
                                break;
                            } else {
                                if(i == usuarios.size() - 1){
                                    System.out.println("Usuário não encontrado!");

                                }

                                logado = false;
                            }
                        }
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                if (logado == false) {
                    System.out.println("\n{1} CRIAR CONTA  --   {2} L0GIN");
                    System.out.print("--> ");
                    enter = Login.nextInt();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }else {
                Conta editarAtributo = new Conta(usuarios.get(index).login, usuarios.get(index).senha, usuarios.get(index).usuario);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                face.Login();
                System.out.println("\n            SEJA BEM-VINDO(a), " + usuarios.get(index).usuario);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("                                             [Amigos] ");
                if (usuarios.get(index).amigos != null) {
                    for (int i = 0; i < usuarios.get(index).amigos.size(); i++) {
                        System.out.println("# " + usuarios.get(index).amigos.get(i));
                    }
                }
                System.out.println("                                                      ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("                                              [Feed]  ");
                if (Post != null) {
                    for (int i = 0; i < Post.size(); i++) {
                    System.out.println(" Post #"+(i+1)+ " às " + now  );
                        System.out.println(Post.get(i));
                        System.out.println("__________________________________________________");

                    }
                }
                System.out.println("                                                          ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("{1} Editar Perfil");
                System.out.println("{2} Adicionar Amigos");
                System.out.println("{3} Solicitações");
                System.out.println("{4} Mensagens");
                System.out.println("{5} Criar Comunidade");
                System.out.println("{6} Recuperar informações");
                System.out.println("{7} Mensagens no Feed");
                System.out.println("{8} Remover conta");
                System.out.println("{9} Sair");
                System.out.print("--> ");
                opcaoLogado = Login.nextInt();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                switch (opcaoLogado) {
                    case 1:
                        System.out.println("QUAL INFORMAÇÃO DESEJA ALTERAR?\n");
                        System.out.println("{1} E-MAIL: " + usuarios.get(index).login);
                        System.out.println("{2} SENHA: " + usuarios.get(index).senha);
                        System.out.println("{3} NOME: " + usuarios.get(index).usuario);
                        System.out.print("--> ");
                        opcaoEditar = Login.nextInt();
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        if (opcaoEditar == 1) {

                            System.out.println("[E-MAIL ATUAL:" + usuarios.get(index).login + "]");
                            System.out.println("Novo E-mail: ");
                            editarAtributo.login = edit.next();
                            usuarios.add(index, editarAtributo);
                            System.out.println("Agora seu e-mail é: " + usuarios.get(index).login);

                        } else if (opcaoEditar == 2) {

                            System.out.println("[SENHA ATUAL:" + usuarios.get(index).senha + "]");
                            System.out.println("Nova senha: ");
                            editarAtributo.senha = edit.next();
                            usuarios.add(index, editarAtributo);
                            System.out.println("Agora sua senha é: " + usuarios.get(index).senha);

                        } else {
                            System.out.println("[Nome Atual:" + usuarios.get(index).usuario + "]");
                            System.out.println("Nova senha: ");
                            editarAtributo.usuario = edit.next();
                            usuarios.add(index, editarAtributo);
                            System.out.println("Agora seu nome de usuário é: " + usuarios.get(index).usuario);
                        }
                        break;
                    case 2:
                        AdicionarAmigos adicionar = new AdicionarAmigos();
                        adicionar.Add(usuarios, index, editarAtributo);
                        break;
                    case 3:
                        Solicitar sol = new Solicitar();
                        sol.paraSolicitar(usuarios,index);
                            break;
                    case 4:
                        System.out.println("{1} Enviar mensagem");
                        System.out.println("{2} Visualizar mensagens");
                        System.out.println("{3} Sair");
                        int op = Login.nextInt();
                        while (op!=3){
                            if (op == 1){
                                EnviarMensagem enviar = new EnviarMensagem();
                                enviar.Enviar(usuarios,index);
                            }
                            else if (op == 2){
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("                    Suas Mensagens                    ");
                                for (int i = 0; i < usuarios.get(index).messages.size(); i++) {
                                    System.out.println("\n#> "+ usuarios.get(index).messages.get(i).receptor );
                                    System.out.println("\n\n |"+ usuarios.get(index).messages.get(i).mensagens+"|");
                                    System.out.println("___________________________________________________________");
                                }
                            }
                            System.out.println("{1} Enviar mensagem");
                            System.out.println("{2} Visualizar mensagens");
                            System.out.println("{3} Sair");
                            op = Login.nextInt();

                        }


                        break;
                    case 5:
                            AdicionarComunidade ads = new AdicionarComunidade();
                            ads.Coms(usuarios,index);
                    case 6:
                        System.out.println("    SOBRE SUAS INFORMAÇÕES      ");
                        System.out.println("___________________________________________________________");
                        System.out.println("~ PERFIL    ");
                        System.out.println("Login: "+usuarios.get(index).login);
                        System.out.println("Senha: "+usuarios.get(index).senha);
                        System.out.println("Usuário: "+usuarios.get(index).usuario);
                        System.out.println("___________________________________________________________");
                        System.out.println("~ Comunidades: ");
                        for (int i = 0; i < usuarios.get(index).minhasComunidades.size(); i++) {
                            System.out.println("Nome: "+usuarios.get(index).minhasComunidades.get(i).nome);
                            System.out.println("Descrição: "+usuarios.get(index).minhasComunidades.get(i).descricao);
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        }
                        System.out.println("___________________________________________________________");
                        System.out.println("~ Amigos: ");
                        for (int i = 0; i < usuarios.get(index).amigos.size(); i++) {
                            System.out.println("# "+usuarios.get(index).amigos.get(i));
                        }
                        System.out.println("    Mensagens      ");
                        case 7:
                            System.out.println(" O que deseja postar? ");
                            System.out.print(">> ");
                            String postagem = Login.next();
                            Post.add(postagem);
                            break;
                    case 8:
                        System.out.println("Realmente deseja excluir sua conta? [Y/n]");
                        String excluir = Login.next();
                        if (excluir.equals("Y")){
                            usuarios.remove(index);
                            logado = false;
                            System.out.println("Conta excluída!!!");
                            break;
                        }

                    case 9:
                        logado = false;
            }

            }




        }
    }
}
