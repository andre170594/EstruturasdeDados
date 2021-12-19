package testemoodle;

import java.util.Iterator;

public class Inteiro implements Iterable<Integer>{

    int valor;

    public Inteiro(int valor) {
        this.valor = valor;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IterInteiro(this);
    }
}
