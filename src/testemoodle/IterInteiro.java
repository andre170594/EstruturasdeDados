package testemoodle;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IterInteiro implements Iterator<Integer> {

    Inteiro inteiro;
    boolean usado = false;

    public IterInteiro(Inteiro inteiro) {
        this.inteiro = inteiro;
    }




    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        throw new NoSuchElementException();
    }
}
