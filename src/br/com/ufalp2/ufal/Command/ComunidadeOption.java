package br.com.ufalp2.ufal.Command;

import br.com.ufalp2.ufal.classes.Comunidade;
import br.com.ufalp2.ufal.classes.Conta;
import br.com.ufalp2.ufal.classes.Menu;
import br.com.ufalp2.ufal.classes.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComunidadeOption extends OpcoesComando {


    @Override
    public void execute(ArrayList<Conta> usuarios, Menu iface, int usuarioLogado, List<Post> posts, List<Comunidade> comunidades) {
        Scanner read = new Scanner(System.in);
        int com = 0;
        try {
            iface.MenuComunidade();
            com = Integer.parseInt(read.nextLine());
            switch (com) {
                case 1:
                    Comunidade comu = new Comunidade();
                    comu.criarComunidade(usuarios, usuarioLogado);
                    comunidades.add(comu);
                    usuarios.get(usuarioLogado).getComunidades().add(comu);
                    break;
                case 2:
                    if (comunidades != null && comunidades.size() != 0) {

                        for (int i = 0; i < comunidades.size(); i++) {
                            System.out.println("{" + (i + 1) + "} " + comunidades.get(i).getTitulo());
                        }
                        System.out.print("Participar da comunidade ~> ");
                        int comunidade = 0;
                        try {

                            comunidade = Integer.parseInt(read.nextLine());
                            //Colocando usuario na lista de comunidades geral
                            comunidades.get(comunidade - 1).getMembros().add(usuarios.get(usuarioLogado));
                            //Colocando comunidades na lista de comuni do usuario
                            usuarios.get(usuarioLogado).getComunidades().add(comunidades.get(comunidade - 1));
                            System.out.println("Você está participando de uma nova comunidade!");

                        } catch (NumberFormatException e) {
                            System.out.println("Opção Inválida!");
                        } catch (IndexOutOfBoundsException i) {
                            System.out.println("\nOpção não existe!\n");
                        }
                    } else {
                        System.out.println("Sem comunidades no Iface.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("\nOpção inválida!!!\n");
        }
    }
}
