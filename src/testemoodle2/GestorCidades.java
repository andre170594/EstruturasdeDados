package testemoodle2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GestorCidades {

    HashMap<String,Cidade> hash = null;

    public GestorCidades(){
        hash = new HashMap<>();
    }

    public void defineCidade(String nome, int populacao){
        Cidade tmp = new Cidade(nome,populacao);
        hash.put(nome,tmp);
    }
    public void migracao(String origem, String destino, int quantos){
        Iterator<Map.Entry<String,Cidade>> it = hash.entrySet().iterator();
        if(!hash.containsKey(origem) || !hash.containsKey(destino)) return;
        if(hash.get(origem).getPopulacao() < quantos) return;

        while (it.hasNext()){
            Cidade tmp = it.next().getValue();
            if(tmp.getNome().equalsIgnoreCase(origem) && tmp.getPopulacao() > quantos)
                tmp.setPopulacao(-quantos);
            if(tmp.getNome().equalsIgnoreCase(destino))
                tmp.setPopulacao(quantos);
        }
    }

    public int getPopulacao(String cidade){ return hash.get(cidade).getPopulacao(); }
}
