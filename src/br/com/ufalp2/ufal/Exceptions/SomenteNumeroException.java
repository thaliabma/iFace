package br.com.ufalp2.ufal.Exceptions;

public class SomenteNumeroException extends Exception{
    protected String numero;

    public SomenteNumeroException(String numero) {
        super();
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Inválido! É permitido somente números.";
    }
}
