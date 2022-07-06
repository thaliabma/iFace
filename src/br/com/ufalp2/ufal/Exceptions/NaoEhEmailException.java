package br.com.ufalp2.ufal.Exceptions;

public class NaoEhEmailException extends Exception{
    protected String email;


    public NaoEhEmailException(String email) {
        super();
        this.email = email;
    }

    @Override
    public String toString() {
        return email + ": Não é considerado e-mail. Precisa conter pelo menos um '@'";
    }
}
