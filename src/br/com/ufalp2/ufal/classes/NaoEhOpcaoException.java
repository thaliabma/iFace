package br.com.ufalp2.ufal.classes;

public class NaoEhOpcaoException extends Exception{
    protected int option;

    public NaoEhOpcaoException(int option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Não é uma opção do menu" ;
    }
}
