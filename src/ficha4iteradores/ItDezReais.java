package ficha4iteradores;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ItDezReais implements Iterator<Double> {

    private final DezReais dr;
    int posUltimo = -1;

    public ItDezReais(DezReais dr) {
        this.dr = dr;
    }

    public void resetIt(){
        posUltimo = -1;
    }

    @Override
    public boolean hasNext() {
        if(posUltimo + 1 > dr.size())
            throw new NoSuchElementException();
        return posUltimo +1 < dr.size();

    }

    @Override
    public Double next() {
        return dr.get(++posUltimo);
    }
}
