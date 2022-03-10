package testemoodle2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class gestorTeste2 {

    int valorCentral;
    PriorityQueue<Integer> antes = null;
    PriorityQueue<Integer> suce = null;

    public gestorTeste2(int valorCentral){
        this.valorCentral = valorCentral;

        antes = new PriorityQueue<>(Comparator.reverseOrder());
        suce = new PriorityQueue<>(Comparator.naturalOrder());
    }

    public void add(int X ){
        if(X < valorCentral){
            antes.add(X);
        }else
            suce.add(X);
    }
    public Integer removaAntecessor(){
        return antes.poll();
    }
    public Integer removeSucessor(){
        return suce.poll();
    }


    public void show() {
        for (Integer val: antes) {
            System.out.print(val + " ");
        }

        System.out.println("\n" +  valorCentral);

        for (Integer val: suce) {
            System.out.print(val + " ");
        }
    }
}
