package ficha5Collections;

import java.util.*;

public class Ficha5 {


    public static <E> void printLists(List<? super E> lista){
        for (Object e : lista) {
            System.out.print(e + " | ");
        }
        System.out.println();
    }

    // EX1
    public static <T> void myFill(List<? super T> lista, T valor){
        ListIterator<T> it = (ListIterator<T>) lista.listIterator();
        while(it.hasNext()){
            it.next();
            it.set(valor);
        }
    }

    // EX5
    public static <T> void myReverse(List<? super T> lista){
        ListIterator<? super T> lii = lista.listIterator();
        ListIterator<? super T> lif = lista.listIterator(lista.size());
        while (lii.nextIndex() < lif.previousIndex()){
            T aux = (T) lii.next();
            lii.set((T)lif.previous());
            lif.set(aux);
        }
    }

    // EX6
    public static <T> void myReverse2(Collection<T> lista ){
        // como posso receber qualquer tipo de lista
        // vou mandar isto para dentro de uma pilha vazia
        // com  Push construo a nova pilha
        Pilha<T> pilha = new Pilha<>(new ArrayList<T>());
        for(T val : lista)
            pilha.Push((val));
        // com o pop consigo ir mostrando o último e removendo
        // por isso acaba por imprimir por ordem inversa
        while (!pilha.Empty())
            System.out.println(pilha.Pop());
    }

    // EX7 A
    public static <T> void removeParesV1(List<T> lista){
        // com a ajuda de um iterador copio apenas os valores
        // em posição impar para uma lista auxiliar
        // agora é só limpar a lista original
        // e copiar lá para dentro a lista auxiliar
        ListIterator<T> li = lista.listIterator();
        List<T> aux = new ArrayList<>(lista.size()/2+1);
        while (li.hasNext()){
            li.next();
            if(li.hasNext())
                aux.add((T)li.next());
        }
        lista.clear();
        lista.addAll(aux);
    }

    // EX7 B
    public static <T> void removeParesV2(List<T> lista){

        ListIterator<T> li = lista.listIterator();
        while (li.hasNext()){
            li.next();
            li.remove();
            if(li.hasNext())
               li.next();
        }
    }

    // Ex8
    // SortedPilha

    public static void main(String[] args) {

        LinkedList<Integer> lista = new LinkedList<>();
        Pilha pi = new Pilha(lista);
        for(int i = 0; i < 5;i++){
            pi.Push(i);
        }
        System.out.println("\nPilha ORIGINAL:");
        pi.MostraPilha();

        LinkedList<Integer> ll = new LinkedList<>();
        Fila fila = new Fila(ll);
        for(int i = 0; i< 5;i++){
            fila.ADD(i);
        }
        System.out.println("\nFILA ORIGINAL:");
        fila.MostraFila();

        System.out.println("\nPilha PEEK:");
        System.out.print( pi.Peek());
        System.out.println("\nPilha POP:");
        pi.Pop();
        pi.MostraPilha();

        System.out.println("\nFILA ELEMENT:");
        System.out.print(fila.Element());

        System.out.println("\nFILA REMOVE:");
        fila.Remove();
        fila.MostraFila();

        System.out.println("\nFILA REVERSED:");
        myReverse(fila.lista);
        fila.MostraFila();

        System.out.println("\nFILA REVERSED x 2:");
        myReverse2(fila.lista);

        System.out.println("\nRemove Pares:");
        fila.lista.add("2.2");
        removeParesV1(fila.getLista());
        fila.MostraFila();

        System.out.println("\n\n******** EX 8 *********");
        SortedPilha<Integer> spilha = new SortedPilha<>();
        spilha.push(5);
        spilha.push(20);
        spilha.push(4);
        spilha.push(30);
        spilha.push(2);
        spilha.push(22);
        spilha.showStack();
        System.out.println("\nMin:" + spilha.findMin());


    }
}
