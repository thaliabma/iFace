package br.com.ufalp2.ufal.Command;

import br.com.ufalp2.ufal.classes.Comunidade;
import br.com.ufalp2.ufal.classes.Conta;
import br.com.ufalp2.ufal.classes.Menu;
import br.com.ufalp2.ufal.classes.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdicionarAmigosOption extends OpcoesComando{
    @Override
    public void execute(ArrayList<Conta> usuarios, Menu iface, int usuarioLogado, List<Post> posts, List<Comunidade> comunidades) {
        Scanner read = new Scanner(System.in);
        System.out.println("Usuários do Iface: ");
        if (usuarios.size() <= 1) {
            System.out.println("\nSó existe você no Iface :( \n");
            return;

        } else {
            for (int i = 0; i < usuarios.size(); i++) {
                if (i == usuarioLogado) {
                    continue;

                } else {
                    System.out.println("{" + (i) + "} " + usuarios.get(i).getNome());
                }
            }
        }

        System.out.print("Adicionar ~> ");
        int ad = 0;

        try {
            ad = Integer.parseInt(read.nextLine());
            usuarios.get(ad).receberSolicitacao(usuarios.get(usuarioLogado), usuarios, usuarioLogado);
            System.out.println("\n Sua solicitação foi enviada para " + usuarios.get(ad).getNome() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("\nOpção inválida!\n");

        } catch (IndexOutOfBoundsException i) {
            System.out.println("\nOpção não existe!\n");
        } finally {
            return;
        }
    }
}
