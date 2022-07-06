package br.com.ufalp2.ufal.Command;

import br.com.ufalp2.ufal.classes.*;

import java.util.ArrayList;
import java.util.List;

public class MensagensOption extends OpcoesComando{
    @Override
    public void execute(ArrayList<Conta> usuarios, Menu iface, int usuarioLogado, List<Post> posts, List<Comunidade> comunidades) {
        MensagemPrivada message = new MensagemPrivada();

        message.menuMensagens(usuarios, usuarioLogado);
    }
}
