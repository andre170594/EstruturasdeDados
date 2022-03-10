package TestZone;


import ficha7BinTrees.Node;

import java.util.Iterator;

public class ListaLigada<T> {

    NodeList<T> root;
    int tam;

    //build
    public ListaLigada(){
        root = null;
        tam = 0;
    }
    public ListaLigada(NodeList<T> novo){
        root = novo;
        tam = 1;
    }

    // add inicio
    public void addInicio(T data){
        root = new NodeList<>(data,root);
        tam++;
    }
    // add final
    public void addFinal(T data){
        NodeList<T> novo = new NodeList<>(data);
        if(root == null){
            root = novo;
        }else {
            NodeList<T> tmp = root;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(novo);
        }
        tam++;
    }
    // remove inicio
    public void removeInicio(){
        if(tam == 1)
            root = null;
        if(tam > 1)
            root = root.getNext();
        if(tam != 0)
            tam--;
    }
    // remove final
    public void removeFinal(){

        if(root == null)
            return;
        if(tam == 1)
            root = null;
        else {
            NodeList<T> tmp = root;
            int idx = 0;
            while (idx < tam - 2) {
                tmp = tmp.getNext();
                idx++;
            }
            tmp.next = null;
        }
        tam--;
    }
    // remove at index
    public void removeAtIndex(int idx){

        // idx fora dos limites
        if(idx < 0 || idx > tam-1) return;
        // inicio
        if(idx == 0){
            removeInicio();
            return;
        }
        // final
        if(idx == tam-1){
            removeFinal();
            return;
        }
        // meio
        NodeList<T> atual = root;
        int flag = 0;
        while (flag < idx-1){
            atual = atual.getNext();
            flag++;
        }
        NodeList<T> neto = atual.getNext().getNext();
        atual.setNext(neto);


    }


    // get inicio
    public NodeList<T> getInicio(){return root;}
    // get final
    public NodeList<T> getFinal(){
        NodeList<T> atual = root;
        while (atual.getNext()!=null){
            atual = atual.getNext();
        }
        return atual;
    }
    // get at index
    public NodeList<T> getAtIndex(int idx){

        NodeList<T> nullNode = new NodeList<>(null,null);

        if(idx < 0 || idx > tam-1)
            return nullNode;

        NodeList<T> atual = root;
        int flag = 0;
        while (flag < idx){
            atual = atual.getNext();
            flag++;
        }
        return atual;
    }


    //print
    public void PrintLista(String info){
        System.out.println(info+":");

        if(root == null)
            System.out.println("lista Vazia");
        else {
            NodeList<T> atual = root;
            while (atual.next != null) {
                System.out.println(atual.data);
                atual = atual.getNext();
            }
            System.out.println(atual.data);
        }
    }

}
