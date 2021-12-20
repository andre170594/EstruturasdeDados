package ficha4iteradores;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ItDezReaisMutavel implements Iterator<Double> {

    private final DezReaisMutavel drm;
    int posUltimo = -1;
    int modsknown = 0;
    boolean podeRemover = false;

    public ItDezReaisMutavel(DezReaisMutavel drm) {
        this.drm = drm;
        this.modsknown = drm.getModificacoes();
    }

    public void verificaMods(){
        if(modsknown != drm.getModificacoes())
            throw new ConcurrentModificationException();
    }

    @Override
    public void remove() {
        if(!podeRemover)
            throw new IllegalStateException();
        podeRemover = false;
        System.out.println("removendo: " + drm.get(posUltimo));
        drm.remove(posUltimo);
        posUltimo--;
        modsknown++;
    }

    @Override
    public boolean hasNext() {
        verificaMods();
        return posUltimo +1 < drm.size();
    }
    @Override
    public Double next() {
        verificaMods();
        if(posUltimo +1 >= drm.size())
            throw new NoSuchElementException();
        podeRemover = true;
        return drm.get(++posUltimo);
    }
}
