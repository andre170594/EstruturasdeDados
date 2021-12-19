package ficha4iteradores;

import java.util.Iterator;

public class DezReaisMutavel extends DezReais {

    private int mods;

    public void remove(int pos){
        mods++;
        for(int i = pos; i < last-1;i++ ){
            numbers[i] = numbers[i +1];
        }
        last--;
    }
    public void acrescenta(Double valor){
        mods++;
        add(valor);
    }

    public int getModificacoes(){ return mods; }

    @Override
    public Iterator<Double> iterator() {
        return new ItDezReaisMutavel(this);
    }
}
