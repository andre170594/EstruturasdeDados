package ficha6;

public class Trabalho {

    private String nome;
    private int pagIni;
    private int pagFin;

    public Trabalho(String nome, int pagIni, int pagFin) {
        this.nome = nome;
        this.pagIni = pagIni;
        this.pagFin = pagFin;
    }

    // gets
    public String getNome() { return nome; }
    public int getPagIni() { return pagIni; }
    public int getPagFin() { return pagFin; }
    public int getNumPags(){ return getPagFin() - getPagIni(); }

    // sets
    public void setNome(String nome) { this.nome = nome; }
    public void setPagIni(int pagIni) { this.pagIni = pagIni; }
    public void setPagFin(int pagFin) { this.pagFin = pagFin; }


    public void show(){
        System.out.println("---> Nome: " + getNome() + " NumPag: " +getNumPags() );
    }



}
