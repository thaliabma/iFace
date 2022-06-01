package br.com.ufalp2.ufal.classes;

public class SomenteLetrasException extends Exception{
    protected String palavra;

    public SomenteLetrasException(String palavra) {
        super();
        this.palavra = palavra;
    }

    @Override
    public String toString() {
        return "A palavra *" + palavra + "* não é um nome válido. Tente escrever somente letras";
    }
}
