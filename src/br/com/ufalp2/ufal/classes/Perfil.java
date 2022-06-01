package br.com.ufalp2.ufal.classes;

public class Perfil extends Pessoa{
    protected String sobreMim;

    public void printP(){
       super.print();
        System.out.println("****************************************");
        System.out.println("Sobre mim: "+this.sobreMim);
        System.out.println("****************************************");
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "sobreMim='" + sobreMim + '\'' +
                '}';
    }

    public Perfil() {
    }

    public String getSobreMim() {
        return sobreMim;
    }

    public void setSobreMim(String sobreMim) {
        this.sobreMim = sobreMim;
    }
}
