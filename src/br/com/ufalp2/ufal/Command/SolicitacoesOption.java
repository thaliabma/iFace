package br.com.ufalp2.ufal.Command;

import br.com.ufalp2.ufal.classes.Comunidade;
import br.com.ufalp2.ufal.classes.Conta;
import br.com.ufalp2.ufal.classes.Menu;
import br.com.ufalp2.ufal.classes.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolicitacoesOption extends OpcoesComando{
    @Override
    public void execute(ArrayList<Conta> usuarios, Menu iface, int usuarioLogado, List<Post> posts, List<Comunidade> comunidades) {
        Scanner read = new Scanner(System.in);
        if (usuarios.get(usuarioLogado).getSolicitacoes() != null && usuarios.get(usuarioLogado).getSolicitacoes().size() != 0) {
            System.out.println("Solicitações: ");

            for (int i = 0; i < usuarios.get(usuarioLogado).getSolicitacoes().size(); i++) {
                System.out.println("{" + (i + 1) + "} " + usuarios.get(usuarioLogado).getSolicitacoes().get(i).getNome());

            }
            System.out.println("----------------------");
            System.out.print("Aceitar solicitação ~> ");
            int sol = 0;
            try {
                sol = Integer.parseInt(read.nextLine());
                int amigo = 0;

                for (int i = 0; i < usuarios.size(); i++) {
                    if (usuarios.get(usuarioLogado).getSolicitacoes().get(sol - 1).equals(usuarios.get(i))) {
                        amigo = i;
                        break;
                    }
                }
                usuarios.get(usuarioLogado).aceitarSolicitacao(sol - 1, usuarios, amigo);
                usuarios.get(amigo).getAmigos().add(usuarios.get(usuarioLogado));
            } catch (NumberFormatException e) {
                System.out.println("\nOpção inválida!\n");

            } catch (IndexOutOfBoundsException i) {
                System.out.println("\nOpção não existe!\n");
            } finally {
                return;
            }
        } else {
            System.out.println("\nVocê não tem solicitações.\n");
            return;
        }
    }
}
