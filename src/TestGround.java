import TestZone.ListaLigada;





public class TestGround {

    public static void main(String[] args) {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.addFinal(0);
        lista.addFinal(1);
        lista.addFinal(2);
        lista.addFinal(3);
        lista.addFinal(4);
        lista.PrintLista("add final");
        System.out.println("get: " + lista.getAtIndex(2).getData());


    }

}
