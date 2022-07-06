package br.com.ufalp2.ufal.Main;

import br.com.ufalp2.ufal.classes.*;
import br.com.ufalp2.ufal.Fachadas.*;

import java.util.ArrayList;

public class Iface {
    public static void main(String[] args) {
        ArrayList<Conta> usuarios = new ArrayList<>();
        Menu iface = new Menu();
        int usuarioLogado = 0;
        boolean logado = false;

        naoLogadoFacade inicio = new naoLogadoFacade();
        estaLogadoFacade principal = new estaLogadoFacade();

        while (true) {
            usuarioLogado = inicio.TelaInicial(usuarios, iface);
            if ( usuarioLogado != -1) {
                logado = true;
            }

            if (logado) {
                while (logado) {
                    logado = principal.TelaPrincipal(usuarios,iface,usuarioLogado);
                }
            }
        }
    }
}
