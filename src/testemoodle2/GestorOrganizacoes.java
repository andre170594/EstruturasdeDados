package testemoodle2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GestorOrganizacoes {

    PriorityQueue<Organizacao> pq = new PriorityQueue<>(new Comparator<Organizacao>() {
        @Override
        public int compare(Organizacao o1, Organizacao o2) {
            if(o1.getNumQueixas() != o2.getNumQueixas())
               return o1.getNumQueixas() - o2.getNumQueixas();
            else return o1.getDataUltimaAuditoria().compareTo(o2.getDataUltimaAuditoria());
        }
    });

    public void add(Organizacao org){
        pq.add(org);
    }
    public boolean contains(Organizacao org){
        return pq.contains(org);
    }
    public Organizacao poll(){
        return pq.poll();
    }
    public int size(){
        return pq.size();
    }
    public Organizacao peel(){
        return pq.peek();
    }

}
