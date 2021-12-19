package ficha5Collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class SortedPilha<T extends Comparable<? super T>> {

    Pilha<T> val = new Pilha<>(new ArrayList<>());  // Todos os vals
    Pilha<T> min = new Pilha<>(new ArrayList<>());  // apenas o mínimos

    public void push(T value){
        // Se a pilha dos mínimos estiver vazia ou o novo
        // valor a adicionar for mais pequeno que o último mínimo
        // adiciona ao topo da pilha dos mínimos (no topo fica o mais pequeno de todos).
        // independentemente disto adiciona na mesma à pilha dos valores normal
        if(min.Empty() || min.Peek().compareTo(value)>=0)
            min.Push(value);
        val.Push(value);
    }
    public T pop(){
        // basta fazer val.Pop() que como já está criado nos métodos da pilha
        // é ele que se preocupa em mostrar e remover o valor do topo da lista
        // neste caso tenho é de verificar se esse valor é igual ao último
        // mínimo para também o remover na pilha dos mínimos.
        T aux = val.Pop();
        if(aux.compareTo(min.Peek())==0)
            min.Pop();
        return aux;
    }
    public T findMin(){
        // mostrar o mínimo é só fazer peek ao último elem da pilha dos mins
        return min.Peek();   // O(1) complexity
    }

    // PRINT
    public void showStack(){
        ListIterator<? super T> li = val.lista.listIterator();
        while (li.hasNext())
            System.out.print("| " + li.next());
    }

}
