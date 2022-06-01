package br.com.ufalp2.ufal.classes;

public abstract class Pessoa {

    protected String nome;
    protected int idade;
    protected String cpf;

    public void print(){
        System.out.println("Nome: "+nome);
        System.out.println("****************************************");
        System.out.println("Idade: "+idade);
        System.out.println("****************************************");
        System.out.println("Cpf: "+cpf);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



}
