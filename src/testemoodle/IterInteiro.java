package testemoodle;

import java.util.Iterator;
import java.util.List;

public class IterInteiro implements Iterator<Integer> {

    Inteiro inteiro;
    public IterInteiro(Inteiro inteiro) {
        this.inteiro = inteiro;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}
