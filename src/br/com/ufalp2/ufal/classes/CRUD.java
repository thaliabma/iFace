package br.com.ufalp2.ufal.classes;

import java.util.ArrayList;

public class CRUD implements BasicDAO{

    @Override
    public void create(ArrayList<Conta> usuarios,Conta usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void delete(ArrayList<Conta> usuarios,Conta usuario) {
        usuarios.remove(usuario);
    }
}
