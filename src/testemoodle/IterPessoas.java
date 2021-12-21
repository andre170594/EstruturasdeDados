package testemoodle;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterPessoas implements Iterator<String> {

    Pessoa p;
    int cnt = 0;

    public IterPessoas(Pessoa p) { this.p = p; }


    public void remove(){
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return cnt < 2;
    }

    @Override
    public String next() {

        if(cnt >= 2)
            throw new NoSuchElementException();

        if(cnt == 0){
            cnt++;
            return p.getNome();

        }
        else{
            cnt++;
            return p.getMorada();
        }

    }
}
