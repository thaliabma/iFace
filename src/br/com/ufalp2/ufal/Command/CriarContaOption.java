package br.com.ufalp2.ufal.Command;

import br.com.ufalp2.ufal.Exceptions.NaoEhEmailException;
import br.com.ufalp2.ufal.Exceptions.SomenteLetrasException;
import br.com.ufalp2.ufal.classes.CRUD;
import br.com.ufalp2.ufal.classes.Conta;
import br.com.ufalp2.ufal.classes.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class CriarContaOption extends OpcoesComando{
    private String login;
    private String nome;
    private String senha;
    Scanner read = new Scanner(System.in);
    CRUD crud = new CRUD();

    public void execute(ArrayList<Conta> usuarios, Menu iface){
        String lerString;
        System.out.println("================== Criar Conta ==================");
        while (true){
            try{
                System.out.print("Email: ");
                this.login = read.nextLine();

                if (!this.login.contains("@")){
                    throw new NaoEhEmailException(this.login);
                }

                System.out.print("Nome: ");
                lerString = read.nextLine();
                this.nome = lerString;

                if (!this.nome.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\s]+$")){
                    throw new SomenteLetrasException(this.nome);
                }

                System.out.print("Senha: ");
                lerString = read.nextLine();
                this.senha = lerString;

                Conta usuario = new Conta(this.login,this.senha);
                usuario.setNome(this.nome);
                crud.create(usuarios,usuario);
                System.out.println("\n      Conta criada! Vá para login\n");

                break;

            } catch (NaoEhEmailException e) {
                System.out.println("----------------------------");
                System.out.println("Insira um e-mail válido!");
                System.out.println("----------------------------");

            } catch (SomenteLetrasException e) {
                System.out.println("----------------------------");
                System.out.println("Insira um nome válido!");
                System.out.println("----------------------------");

            }
            finally {
                break;
            }
        }
    }
}
