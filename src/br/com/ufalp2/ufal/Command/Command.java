package br.com.ufalp2.ufal.Command;

import br.com.ufalp2.ufal.classes.Comunidade;
import br.com.ufalp2.ufal.classes.Conta;
import br.com.ufalp2.ufal.classes.Menu;
import br.com.ufalp2.ufal.classes.Post;

import java.util.ArrayList;
import java.util.List;

public interface Command {
    void execute(ArrayList<Conta> usuarios, Menu iface, int usuarioLogado, List<Post> posts,List<Comunidade> comunidades );

}
