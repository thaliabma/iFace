package br.com.ufalp2.ufal.Exceptions;

public class CpfValidoException extends Exception{
    protected String cpf;

    public CpfValidoException(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "CPF inválido! Números de dígitos precisa ser 11.";
    }
}
