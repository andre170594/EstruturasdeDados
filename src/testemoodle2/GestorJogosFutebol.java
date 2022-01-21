package testemoodle2;

import java.util.*;

public class GestorJogosFutebol {

    private HashMap<Integer,JogoFutebol> hash = null;
    int numJogo;


    public GestorJogosFutebol() {
        hash = new HashMap<>();
        numJogo = 0;
    }

    public void defineJogo(String eqCasa, String eqVisi, int assist){
        JogoFutebol tmp = new JogoFutebol(eqCasa,eqVisi,assist);
        hash.put(numJogo,tmp);
        numJogo++;

    }

    public int getAssistenciaTotalEmCasa(String nomeEquipa){
        Iterator<Map.Entry<Integer, JogoFutebol>> it = hash.entrySet().iterator();
        int sum = 0;
        while (it.hasNext()){
            JogoFutebol tmp = it.next().getValue();
            if(tmp.getEqCasa().equalsIgnoreCase(nomeEquipa)){
                sum+=tmp.getAssist();
            }
        }
        return sum;
    }

    public List<String> getEquipasVisi(String nomeEquipa){
        List<String> lista = new ArrayList<>();
        Iterator<Map.Entry<Integer,JogoFutebol>> it = hash.entrySet().iterator();
        while (it.hasNext()){
            JogoFutebol tmp = it.next().getValue();
            if(tmp.getEqCasa().equalsIgnoreCase(nomeEquipa) && !lista.contains(tmp.getEqVisi()))
                lista.add(tmp.getEqVisi());
        }
        return lista;

    }

}
