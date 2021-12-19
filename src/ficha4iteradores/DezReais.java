package ficha4iteradores;

import java.util.Arrays;
import java.util.Iterator;

public class DezReais  implements Iterable<Double> {
     final int CAPACITY = 10;
     Double[] numbers = new Double[CAPACITY];
     int last = 0;

     public int size(){return last; }
     public Double get(int pos){return numbers[pos];}

     public boolean add(Double num){
         if(last < 10){
             numbers[last++] = num;
             return true;
         }else{
             throw new RuntimeException();
         }
     }

    @Override
    public Iterator<Double> iterator() {
        return new ItDezReais(this);
    }
    @Override
    public String toString() {
        return "Class DezReais";
    }
}
