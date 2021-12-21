package testemoodle;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterPessoas implements Iterator<Pessoa> {

    Pessoa p;
    boolean visto = false;

    public IterPessoas(Pessoa p) { this.p = p; }


    public void remove(){
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return !visto;
    }

    @Override
    public Pessoa next() {
        if(visto)
            throw new NoSuchElementException();
        else{
            visto = true;
            return p;
        }

    }
}
