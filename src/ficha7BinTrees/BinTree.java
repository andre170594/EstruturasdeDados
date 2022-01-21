package ficha7BinTrees;

import java.util.Comparator;

public class BinTree<T extends Comparable<? super T>> {
    private Node<T> root;
    private Comparator<T> comp;

    public BinTree(Comparator<T> comp){
        this.comp = comp;
        Node<T> nullNode = new Node<>();
        nullNode.setLeft(null);
        nullNode.setRight(null);
        root = nullNode;
    }
    public BinTree(){
        comp = Comparator.naturalOrder();
    }

    // GETS
    public Node<T> getRoot(){return root;}
    // SETS
    public void setRoot(Node<T> root){this.root = root;}


    // INSERIR NODE RECURSIVE
    public void insere(T data){
        Node<T> newNode = new Node<>(data);
        root = insere(root,newNode);
    }
    private Node<T> insere(Node<T> root, Node<T> newNode){
        if(root == null)
            return newNode;
        if(newNode == null)
            return root;

        int cmp = comp.compare(root.getData(), newNode.getData());

        if(cmp == 0)
            throw new RuntimeException();
        else{
            if(cmp< 0)
                root.setLeft(insere(root.getLeft(),newNode));
            if(cmp>0)
                root.setRight(insere(root.getRight(),newNode));
        }
        return root;
    }

    // CONTEM NODE RECURSIVE
    public boolean contemDados(T data){ return contemDados(root,data);}
    private boolean contemDados(Node<T> n, T data) {
        if(n == null)
            return false;

        int c = comp.compare(n.getData(),data);

        if(c==0)
            return true;
        if(c < 0)
            return contemDados(n.getLeft(),data);
        else
            return contemDados(n.getRight(),data);

    }

    // PROFUNDIDADE DE data RECURSIVE
    public int profundidade(T data){return profundidade(root,data); }
    private int profundidade(Node<T> n, T data) {
        int d;
        if(n == null)                        // está no nivel 0 porque nem raiz tem
            return 0;

        if(data.compareTo(n.getData())==0)  // só tem raiz
            return 1;

        d = profundidade(n.getLeft(),data);
        if(d>0)
            return d + 1;

        d = profundidade(n.getRight(),data);
        if(d> 0)
            return d +1;
        return 0;
    }

    // PROFUNDIDADE DE UMA ARVORE
    public int profundidadeArvore(){
        return profundidade(root);
    }
    private int profundidade(Node<T> n) {
        if(n==null)
            return 0;
        int dl = profundidade(n.getLeft());
        int dr = profundidade(n.getRight());

        return dl > dr ? dl +1 : dr +1;

    }

    // TAMANHO : num de nós da arvore
    public int tamanho(){ return tamanho(root);}
    private int tamanho(Node<T> n) {
        if(n == null)
            return 0;
        return 1 + tamanho(n.getLeft()) + tamanho(n.getRight());
    }

    // FIND MIN
    public Node<T> findMin(Node<T> n){
        if(n == null)
            return null;
        if(n.getLeft() == null)
            return n;
        else
            return findMin(n.getLeft());
    }

    // REMOVER
    public void remove(T value){root = remove(root,value);}
    private Node<T> remove(Node<T> root, T value) {
        if(root == null)
            return null;

        int cmp = comp.compare(value,root.getData());
        if(cmp > 0){ root.setLeft(remove(root.getLeft(),value));    return root; }
        if(cmp < 0){ root.setRight(remove(root.getRight(),value));  return root; }

        // cmp == 0    este é que deve ser apagado!
        if(root.getLeft()==null && root.getRight() == null) return null; // n tem filhos
        if(root.getLeft() == null) return root.getRight();               // só tem filho direito
        if(root.getRight() == null) return root.getLeft();               // só tem filho esquerda

        // se chegou aqui é pq tem dois filhos
        Node<T> min = minimumElement(root.getRight()); // encontrar minimo na subtree à direita para substituir o pai
        root.setData(min.getData());
        root.setRight(remove(root.getRight(), min.getData()));
        return root;

    }
    private Node<T> minimumElement(Node<T> root) {
        if(root.getLeft() == null) return root;
        return minimumElement(root.getLeft());
    }

    // REMOVER MENORES QUE X
    public void removeMenores(T x){
        root = removeMenores(root,x);
    }
    private Node<T> removeMenores(Node<T> root, T x) {
        if(root == null)
            return null;
        root.setLeft(removeMenores(root.getLeft(),x));
        root.setRight(removeMenores(root.getRight(),x));
        if(root.getData().compareTo(x) < 0){
            Node<T> child = root.getLeft();
            root = null;
            return child;
        }
        return root;
    }


    // PRINTS
    public void printInOrder(Node<T> atual){
        if(atual!=null){
            printInOrder(atual.getLeft());
            System.out.println(atual.getData());
            printInOrder(atual.getRight());
        }
    }
    public void printPreOrder(Node<T> atual){
        if(atual!=null){
            System.out.println(atual.getData());
            printPreOrder(atual.getLeft());
            printPreOrder(atual.getRight());
        }

    }
    public void printPostOrder(Node<T> atual){
        if(atual!=null){
            printPostOrder(atual.getLeft());
            printPostOrder(atual.getRight());
            System.out.println(atual.getData());
        }
    }
    public void printLeaves(Node<T> atual){

        if(atual!=null){
            printLeaves(atual.getLeft());
            if(atual.getRight() == null && atual.getLeft() == null)
                System.out.println(atual.getData());
            printLeaves(atual.getRight());
        }
    }



}
