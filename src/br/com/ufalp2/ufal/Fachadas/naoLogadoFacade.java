package br.com.ufalp2.ufal.Fachadas;

import br.com.ufalp2.ufal.Command.CriarContaOption;
import br.com.ufalp2.ufal.Command.LoginOption;
import br.com.ufalp2.ufal.classes.Conta;
import br.com.ufalp2.ufal.classes.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class naoLogadoFacade {

    private Scanner read = new Scanner(System.in);

    public int TelaInicial(ArrayList <Conta> usuarios, Menu iface){

        int status = -1;
        int lerInicio = 0;
        iface.logoInicio();
//        OpcoesComando a[] = new OpcoesComando[3];
//
//        a[1] = new CriarConta();
//        a[lerInicio].execute(usuarios,iface);
        try{

            lerInicio = Integer.parseInt(read.nextLine());

        }catch (NumberFormatException e){
            System.out.println("Inválido!");
        }

        switch (lerInicio){
            case 1:
                CriarContaOption c = new CriarContaOption();
                c.execute(usuarios,iface);
                break;
            case 2:
                LoginOption l = new LoginOption();
                status = l.exec(usuarios,iface);
                break;
            default:
                System.out.println("\nEssa opção não existe\n");
                break;
        }
    return status;
    }
}
