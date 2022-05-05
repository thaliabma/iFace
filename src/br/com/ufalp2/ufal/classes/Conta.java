package br.com.ufalp2.ufal.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta extends Perfil{
    private String login;



    private String senha;
    private List<Conta> amigos = new ArrayList<>(); ;
    private List<Conta> solicitacoes = new ArrayList<>(); ;
    private List<MensagemPrivada> mensagens = new ArrayList<>();
    private List<Comunidade> comunidades = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();



    @Override
    public String toString() {
        return "Conta{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public void receberSolicitacao(Conta solicitante, List<Conta> usuarios, int usuarioLogado) {
        this.solicitacoes.add(solicitante);

    }

    public List<Conta> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Conta> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public void adicionarAmigos(Conta amigo){
        this.amigos.add(amigo);
    }

    public void aceitarSolicitacao(int solicitante, List<Conta> usuarios, int usuarioSolicitante ){
        Conta solic = this.solicitacoes.get(solicitante);
        this.solicitacoes.remove(solicitante);
        adicionarAmigos(solic);
    }

    public void visualizarConta(){
        super.printP();
        System.out.println("Email: "+this.login);
        System.out.println("Senha: "+this.senha);
        System.out.println("Seus Amigos:");
        if (this.amigos != null && this.amigos.size() != 0  ){

        for (Conta m:
                this.amigos) {
            System.out.println("- "+m.getNome());
        }
        }else{
            System.out.println("O usuário não tem amigos adicionados.");
        }
        System.out.println("Suas Solicitações:");

        if (this.solicitacoes != null && this.solicitacoes.size() != 0 ){
            for (Conta m:
                    this.solicitacoes) {
                System.out.println("- "+m.getNome());
            }
        }else{
            System.out.println("O usuário não tem solicitações.");
        }
        System.out.println("Suas Comunidades:");

        if (this.comunidades != null && this.comunidades.size() != 0 ){
            for (Comunidade m:
                    this.comunidades) {
                System.out.println("- "+m.getTitulo());
            }
        }else{
            System.out.println("O usuário não participa de comunidades.");
        }
        System.out.println("Suas Mensagens:");

        if (this.comunidades != null && this.comunidades.size() != 0 ){
            for (Comunidade m:
                    this.comunidades) {
                System.out.println("- "+m.getTitulo());
            }
        }else{
            System.out.println("O usuário não participa de comunidades.");
        }
    }

    public void editar(){
        Scanner input = new Scanner(System.in);
        System.out.println("Você pode editar ou preencher novos campos para enriquecer seu perfil!");
        System.out.println("{1} Email: "+this.login);
        System.out.println("{2} Senha: "+this.senha);
        System.out.println("{3} Nome: "+super.nome);
        System.out.println("{4} Idade: "+super.idade);
        System.out.println("{5} Cpf: "+super.cpf);
        System.out.println("{6} Sobre mim: "+super.sobreMim);
        System.out.print("~> ");
        int result = input.nextInt();
        System.out.println("------------------- ");

        switch (result){
            case 1:
                System.out.print("Novo Email: ");
                String novo = input.next();
                System.out.println("\n");
                this.login = novo;
                break;
            case 2:
                System.out.print("Novo Senha: ");
                String novo1 = input.next();
                System.out.println("\n");
                this.senha = novo1;
                break;
            case 3:
                System.out.print("Novo Nome: ");
                String novo2 = input.next();
                super.nome = novo2;
                break;
            case 4:
                System.out.print("Idade: ");
                int novo3 = input.nextInt();
                super.idade = novo3;
                break;
            case 5:
                System.out.print("CPF: ");
                String novo4 = input.next();
                super.cpf = novo4;
                break;
            case 6:
                System.out.print("Sobre Mim: ");
                String novo5 = input.next();
                super.sobreMim = novo5;
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }



    }

    public List<Comunidade> getComunidades() {
        return comunidades;
    }

    public void setComunidades(List<Comunidade> comunidades) {
        this.comunidades = comunidades;
    }

    public Conta(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Conta() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Conta> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Conta> amigos) {
        this.amigos = amigos;
    }

    public List<MensagemPrivada> getMensagens() {
        return mensagens;
    }
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    public void setMensagens(List<MensagemPrivada> mensagens) {
        this.mensagens = mensagens;
    }

}
