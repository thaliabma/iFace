package br.com.ufalp2.ufal.Fachadas;

import br.com.ufalp2.ufal.Command.*;
import br.com.ufalp2.ufal.Exceptions.NaoEhOpcaoException;
import br.com.ufalp2.ufal.classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class estaLogadoFacade {
    List<Post> posts = new ArrayList<>();
    List<Comunidade> comunidades = new ArrayList<>();
    Scanner read = new Scanner(System.in);
    OpcoesComando escolha[] = new OpcoesComando[11];


    public boolean TelaPrincipal(ArrayList <Conta> usuarios, Menu iface, int usuarioLogado){
        int option = 0;
        this.escolha[0] = new EditarPerfilOption();
        this.escolha[1] = new AdicionarAmigosOption();
        this.escolha[2] = new SolicitacoesOption();
        this.escolha[3] = new MensagensOption();
        this.escolha[4] = new ComunidadeOption();
        this.escolha[5] = new RecuperarInfoOption();
        this.escolha[6] = new NovoPostOption();
        boolean logado = true;
        iface.boasVindas(usuarios, usuarioLogado, posts, comunidades);

        try {
            option = Integer.parseInt(read.nextLine());
            if (option == 0 || option > 9) {
                throw new NaoEhOpcaoException(option);
            }
            if (option == 8 ){
                System.out.println("DESEJA EXCLUIR SUA CONTA? (y/n)");
                String in = read.nextLine();
                if (in.equals("y")) {
                    usuarios.remove(usuarioLogado);
                    System.out.println("CONTA EXCLUÍDA");
                    logado = false;
                } else if (in.equals("n")) {
                    System.out.println("Cancelando operação");
                } else {
                    System.out.println("Opção inválida");
                }
            }else if(option == 9){
                logado = false;
            }else{
                escolha[option-1].execute(usuarios,iface,usuarioLogado,posts,comunidades);
            }
        } catch (NumberFormatException | NaoEhOpcaoException | NullPointerException  e) {
            System.out.println("\nOpção inválida!\n");
        }

        return logado;
    }

}
