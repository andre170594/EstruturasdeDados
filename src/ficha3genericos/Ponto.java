package ficha3genericos;

public class Ponto<X extends Number, Y extends Number>{

    private X x;
    private Y y;

    public Ponto(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    // gets
    public X getX() {
        return x;
    }
    public Y getY() {
        return y;
    }

    // sets
    public void setX(X x) {
        this.x = x;
    }
    public void setY(Y y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "( " + x  + " , " + y + " )";
    }

    public void copy(Ponto<? extends  X, ? extends Y> p){
        setX(p.getX());
        setY(p.getY());
    }
}
