package ficha3genericos;

public class Figura implements Comparable<Figura>{

    private double area;

    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Figura o) {
        return Double.compare(this.getArea(),o.getArea() );
    }
    @Override
    public String toString() {
        return "Figura";
    }
}
