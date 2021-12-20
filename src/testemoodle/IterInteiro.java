package testemoodle;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterInteiro implements Iterator<Integer> {

    Inteiro inteiro;
    boolean usado = false;

    public IterInteiro(Inteiro inteiro) {
        this.inteiro = inteiro;
    }

    @Override
    public boolean hasNext() {
        return !usado;
    }

    @Override
    public Integer next() {
        if (usado)
            throw new NoSuchElementException();
        else{
            usado = true;
            return inteiro.valor;
        }
    }
}
