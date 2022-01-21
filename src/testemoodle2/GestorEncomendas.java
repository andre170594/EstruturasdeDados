package testemoodle2;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

public class GestorEncomendas {
    class Encomenda{
        boolean urgente;
        Date dataPedido;

        public Encomenda(boolean urgente, Date dataPedido) {
            this.urgente = urgente;
            this.dataPedido = dataPedido;
        }

        @Override
        public String toString() {
            return "Urgente: " + urgente + " Date: " + dataPedido;
        }
    }
    PriorityQueue<Encomenda> pq = null;

    public GestorEncomendas(){
        pq = new PriorityQueue<>(new Comparator<Encomenda>() {
            @Override
            public int compare(Encomenda o1, Encomenda o2) {
                int first = 0, scnd = 0;
                if(o1.urgente)
                    first = 1;
                if(o2.urgente)
                    scnd = 1;

                if(first < scnd)
                    return 1;
                else if(first > scnd)
                    return -1;
                else
                  return  o1.dataPedido.compareTo(o2.dataPedido);

            }
        });
    }
    // add
    public void add(boolean ped, Date data){
        Encomenda tmp = new Encomenda(ped,data);
        pq.add(tmp);
    }
    public Encomenda poll(){ return pq.poll(); }
    public Encomenda peek(){ return pq.peek(); }
    public Encomenda remove(){ return pq.remove(); }
    public boolean isEmpty(){ return pq.isEmpty(); }
    public int size(){ return pq.size(); }
}
