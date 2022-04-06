package Application;

import java.util.ArrayList;
import java.util.Scanner;

public class AdicionarAmigos {
    ArrayList<Conta> usuarioAdicionar = new ArrayList<>();
    Scanner solicitar = new Scanner(System.in);

    public void Add(ArrayList<Conta> usuarios, int index, Conta aux){
        for (int i = 0; i < usuarios.size(); i++) {
            if (i != index){
                usuarioAdicionar.add(usuarios.get(i));
            }
        }
        System.out.println("----- Usuários da plataforma iFace -----");
        for (int i = 0; i < usuarioAdicionar.size(); i++) {
            System.out.println("{"+(i + 1)+"} "+usuarioAdicionar.get(i).usuario);

        }
        System.out.println("Solicitar amizade para [número]: ");
        int solic = solicitar.nextInt();

        //Mandar solicitação para index de solic
        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).usuario.equals(usuarioAdicionar.get(solic-1).usuario)) {
                usuarios.get(i).solicitacoes.add(usuarios.get(index).usuario);
                System.out.println("Você enviou um pedido de amizade para "+usuarios.get(i).usuario);
                break;
            }
        }
    }
}
