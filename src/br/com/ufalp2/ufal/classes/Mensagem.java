package br.com.ufalp2.ufal.classes;

public abstract class Mensagem {
    protected String corpo;
    protected Conta remetente;

    public Mensagem(String corpo, Conta remetente) {
        this.corpo = corpo;
        this.remetente = remetente;
    }

    public Mensagem() {
    }



    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Conta getRemetente() {
        return remetente;
    }

    public void setRemetente(Conta remetente) {
        this.remetente = remetente;
    }
}

