package ficha7BinTrees;

// class Nó

public class Node<T> {
    private T data;
    private Node<T> left, right;

    public Node(T data){this.data = data;}
    public Node(){ /* empty build */ }

    // GETS
    public Node<T> getLeft(){ return left;}
    public Node<T> getRight(){return right;}
    public T getData(){return data;}
    // SETS
    public void setLeft(Node<T> left){this.left = left;}
    public void setRight(Node<T> right){this.right = right;}
    public void setData(T data){this.data = data;}

}
