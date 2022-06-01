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
        System.out.println("                 MINHA CONTA            \n");
        super.printP();
        System.out.println("Email: "+this.login);
        System.out.println("****************************************");
        System.out.println("Senha: "+this.senha);
        System.out.println("****************************************");
        System.out.println("             SEUS AMIGOS:               ");
        if (this.amigos != null && this.amigos.size() != 0  ){

        for (Conta m:
                this.amigos) {
            System.out.println("- "+m.getNome());
        }
        }else{
            System.out.println("O usuário não tem amigos adicionados.");
        }
        System.out.println("****************************************");

        System.out.println("             SUAS SOLICITAÇÕES:               ");


        if (this.solicitacoes != null && this.solicitacoes.size() != 0 ){
            for (Conta m:
                    this.solicitacoes) {
                System.out.println("- "+m.getNome());
            }
        }else{
            System.out.println("O usuário não tem solicitações.");
        }
        System.out.println("****************************************");

        System.out.println("             SUAS COMUNIDADES:             ");

        if (this.comunidades != null && this.comunidades.size() != 0 ){
            for (Comunidade m:
                    this.comunidades) {
                System.out.println("- "+m.getTitulo());
                System.out.println("_______________________________________");

            }
        }else{
            System.out.println("O usuário não participa de comunidades.");
        }
        System.out.println("****************************************");

        System.out.println("             SUAS MENSAGENS:             ");

        if (this.mensagens != null && this.mensagens.size() != 0 ){
            for (MensagemPrivada m:
                    this.mensagens) {
                System.out.println("De: "+m.remetente.nome);
                System.out.println("- "+m.corpo);
                System.out.println("_______________________________________");
            }
        }else{
            System.out.println("O usuário não tem mensagens.");
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
        int result = 0;
        try {
            result = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
        }
        System.out.println("------------------- ");
        switch (result){
            case 1:
                try{
                System.out.print("Novo Email: ");
                String novo = input.next();

                if (!novo.contains("@")){
                    throw new NaoEhEmailException(novo);
                }

                this.login = novo;
                System.out.print("\nEditado!\n\n");
                } catch (NaoEhEmailException e) {
                    System.out.println("----------------------------");
                    System.out.println("Insira um e-mail válido!");
                    System.out.println("----------------------------");
                }
                break;
            case 2:
                System.out.print("Novo Senha: ");
                String novo1 = input.next();
                this.senha = novo1;
                System.out.print("\nEditado!\n\n");

                break;
            case 3:
                System.out.print("Novo Nome: ");
                String novo2 = input.next();
                try {
                    if (!novo2.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\s]+$")){
                        throw new SomenteLetrasException(nome);
                    }
                    super.nome = novo2;
                    System.out.print("\nEditado!\n\n");
                } catch (SomenteLetrasException e) {
                    System.out.println("----------------------------");
                    System.out.println("Insira um nome válido!");
                    System.out.println("----------------------------");
                }
                break;
            case 4:
                System.out.print("Idade: ");
                int novo3 = 0;
                try
                {
                    novo3 = Integer.parseInt(input.nextLine());
                    super.idade = novo3;
                    System.out.print("\nEditado!\n\n");
                }
                catch(NumberFormatException e)
                {
                    System.out.println("----------------------------");
                    System.out.println("Insira uma idade válida!");
                    System.out.println("----------------------------");
                }
                finally{
                    break;
                }

            case 5:
                System.out.print("CPF: ");
                String novo4 = input.next();
                try{
                    if (!novo4.matches("[0-9]*")){
                        throw new SomenteNumeroException(novo4);
                    }
                    if (novo4.length() != 11){
                        throw new CpfValidoException(novo4);

                    }
                    super.cpf = novo4;
                    System.out.print("\nEditado!\n\n");
                } catch (SomenteNumeroException e) {
                    System.out.println("----------------------------");
                    System.out.println("Insira um cpf válido!");
                    System.out.println("----------------------------");
                } catch (CpfValidoException e) {
                    System.out.println("----------------------------");
                    System.out.println("CPF precisa conter 11 dígitos!");
                    System.out.println("----------------------------");
                }
                break;
            case 6:
                System.out.print("Sobre Mim: ");
                String novo5 = input.next();
                super.sobreMim = novo5;
                System.out.print("\nEditado!\n\n");

                break;
            default:
                System.out.println("Opção inválida!\n");
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
