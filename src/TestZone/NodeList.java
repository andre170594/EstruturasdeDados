package TestZone;

public class NodeList<T> {

    T data;
    NodeList<T> next;

    //build
    public NodeList(){
        this.data = null;
        this.next = null;
    }
    public NodeList(T data){
        this.data = data;
        this.next = null;
    }
    public NodeList(T data, NodeList<T> next){
        this.data = data;
        this.next=next;
    }

    //gets
    public T getData(){return data;}
    public NodeList<T> getNext(){return next;}
    public NodeList<T> getMe(){return this;}

    // sets
    public void setData(T data){this.data = data;}
    public void setMe(NodeList<T> novo){
        this.data = novo.data;
        this.next = novo.next;
    }
    public void setNext(NodeList<T> prox){
        this.next = prox;
    }

}
