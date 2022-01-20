package ficha6;

import java.util.Comparator;
import java.util.PriorityQueue;




public class Impressora {

    private String nome;
    private String marca;
    private String modelo;

     PriorityQueue<Trabalho> pq = new PriorityQueue<>(new Comparator<Trabalho>() {
         @Override
         public int compare(Trabalho a, Trabalho b) {
             return a.getNumPags() - b.getNumPags();
         }
     });


    // BUILD
    public Impressora(String nome, String marca, String modelo) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
    }


    // METODOS
    public boolean temProximoTrab(){ return !pq.isEmpty(); }
    public Trabalho proximoTrab(){ return pq.poll(); }
    public void enviaTrab(Trabalho t){ pq.add(t);}
    public int getNumTrabs(){return pq.size(); }
    public PriorityQueue<Trabalho> getPq(){return pq;}


    // GETS
    public String getNome() { return nome; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    // SETS
    public void setNome(String nome) { this.nome = nome; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    // PRINT
    public void show(){
        System.out.println("Nome: " + getNome() + " Marca: " + getMarca() + " Modelo: " + getModelo());
    }
    public void showTrabsFIla(){
        System.out.println("\nlista trabalhos impressora: " + getNome());
        for (Trabalho trabalho : pq) {
            trabalho.show();
        }
        System.out.println("");
    }
    public void imprimeTrab(){
        Trabalho tmp = pq.poll();
        if (tmp != null) {
            System.out.println("\nimprimindo ... ");
            tmp.show();

        }
        else{
            System.out.println("trabalho corrompido");
        }
    }
}
