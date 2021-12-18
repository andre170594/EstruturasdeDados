package ficha5Collections;

import java.util.List;
import java.util.ListIterator;

// FILA ou QUEUE
//                                                      <||HEAD||  BODY  |  BODY  |  BODY  |  BODY  |  TAIL ||
//    FIRST IN FIRST OUT (FIFO) logic
//    elementos novos são adicionados na tail
//    elementos à cabeça são removidos
//    o primeiro a chegar é o primeiro a sair

public class Fila<T> {

    List<? super T> lista;
    public Fila(List<? super T> lista) {
        this.lista = lista;
    }

    // ADD  adiciona o elem ao final
    public boolean ADD(T value){
        return lista.add(value);
    }
    // REMOVE  devolve e remove a cabeça
    public T Remove(){
        T aux = (T) lista.get(0);
        lista.remove(0);
        return aux;
    }

    // ELEMENT Devolve a cabeça sem a remover
    public T Element(){
        ListIterator<? super T> li = lista.listIterator();
        return (T) li.next();
    }

    public List<? super T> getLista(){return lista;}

    public void MostraFila(){
        for (Object o : lista) {
            System.out.print("| " + o);
        }
    }

}
