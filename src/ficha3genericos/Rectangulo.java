package ficha3genericos;

public class Rectangulo extends Figura {

    private double alt;
    private double lar;

    public Rectangulo(int alt, int lar){
        this.alt = alt;
        this.lar = lar;
    }

    @Override
    public double getArea() {
        return alt * lar;
    }

    @Override
    public String toString() {
        return "Rectangulo com area: " + getArea();
    }
}
