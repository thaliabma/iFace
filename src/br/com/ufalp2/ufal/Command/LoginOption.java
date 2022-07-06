package br.com.ufalp2.ufal.Command;

import br.com.ufalp2.ufal.classes.Conta;
import br.com.ufalp2.ufal.classes.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginOption {
    private String email;
    private String senha;
    Scanner read = new Scanner(System.in);

    public int exec(ArrayList<Conta> usuarios, Menu iface){
        int usuarioLogado = 0;
        boolean logado = false;

        System.out.println("================== Login ==================");
        String lerString;

        System.out.print("Email: ");
        lerString = read.nextLine();
        this.email = lerString;

        System.out.print("Senha: ");
        lerString = read.nextLine();
        this.senha = lerString;

        Conta usuarioLog = new Conta(this.email, this.senha);

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getLogin().equals(usuarioLog.getLogin()) && usuarios.get(i).getSenha().equals(usuarioLog.getSenha()) ) {
                usuarioLogado = i;
                System.out.println("Usuario>"+ usuarioLogado);
                return usuarioLogado;
            } else {
                if(i == usuarios.size() - 1){
                    System.out.println("\nUsuário não encontrado!\n");
                    logado = false;
                }
            }
        }
        return -1;
    }
}
