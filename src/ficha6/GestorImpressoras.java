package ficha6;

import java.util.*;

public class GestorImpressoras {

    private HashMap<String,Impressora> listaImpressoras = new HashMap<>();
    private PriorityQueue<Impressora> impressoras = new PriorityQueue<>(new Comparator<Impressora>() {
        @Override
        public int compare(Impressora a, Impressora b) {
            return a.getNumTrabs()-b.getNumTrabs();
        }
    });

    public GestorImpressoras(){}
    public HashMap<String, Impressora> getMapa(){return listaImpressoras;}

    public Impressora getPrinter(String nome){return listaImpressoras.get(nome); }
    public Set<String> getNomesImpressora(){return listaImpressoras.keySet(); }
    public void acrescentaImpressora(Impressora novaImp){
        listaImpressoras.put(novaImp.getNome(),novaImp);
        impressoras.add(novaImp);
    }
    public void removeImpressora(String key){listaImpressoras.remove(key); }
    public boolean exiteImpressora(String key){ return listaImpressoras.containsKey(key); }

    public void imprime(Trabalho t){
        Impressora imp = impressoras.remove();
        imp.enviaTrab(t);
        impressoras.add(imp);
    }
    public void mostraFila(){
        for (Impressora impressora : impressoras) {
            System.out.println("\nlista imp: " + impressora.getNome() + ":");
              PriorityQueue<Trabalho> pq = impressora.getPq();
              if(pq.size()>0) {
                  for (Trabalho tra : pq) {
                      tra.show();
                  }
              }else{
                  System.out.println("---> empty");
              }
        }
    }

}
