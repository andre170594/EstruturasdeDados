package ficha5Collections;


import java.util.List;
import java.util.ListIterator;

// PILHA OU STACK

//      |  6   |     <-- Ultimo a ser adicionado        |    Cada novo elemento é adicionado ao topo da pilha.
//      |  5   |                                        |    O último a ser adicionado é o primeiro a sair.
//      |  4   |                                        |    Possui uma lista interna do tipo List<>
//      |  3   |                                        |    que generificando consegue suportar qualquer tipo
//      |  2   |                                        |    de objectos.
//      |  1   |                                        |    Possui alguns métodos caracteristicos tais como:
//      |  0   |     <-- Primeiro a ser adicionado      |    Empty(), Peek(),Pop(),Push();
//    ___________

public class Pilha <T>{

    List<? super T> lista;

    public Pilha(List<? super T> lista){
        this.lista = lista;
    }

    // EMPTY -> Test if the stack is empty
    public boolean Empty(){return lista.isEmpty();}

    // PEEK ->  Looks at the object on top of the stack without removing it
    public T Peek(){
        ListIterator<? super T> li = lista.listIterator(lista.size());
        return (T)li.previous();
    }
    // POP -> Removes the object at the top of this stack and returns that object as the value of this function.
    public T Pop(){
        ListIterator<? super T> li = lista.listIterator(lista.size());
        T aux = (T)li.previous();
        li.remove();
        return aux;
    }
    // PUSH -> Pushes an item onto the top of this stack.
    public boolean Push(T value){
        return lista.add(value);
    }


    public void MostraPilha(){
        ListIterator<? super T> li = lista.listIterator();
        while (li.hasNext()){
            System.out.print("| " + li.next());
        }
    }

}
