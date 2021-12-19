package ficha4iteradores;

public class FIcha4 {
    public static void main(String[] args) {
        System.out.println("ficha4");

        DezReais dr = new DezReais();
        dr.add(1.1);
        dr.add(3.3);
        dr.add(5.1);
        dr.add(3.2);
        dr.add(7.2);
        dr.add(0.2);

        ItDezReais it = new ItDezReais(dr);
        while (it.hasNext()){
            System.out.println(it.next());
        }
        it.resetIt();
        System.out.println("Maior:" + devolveMaior(dr,it));
    }

    private static <T extends DezReais,E extends ItDezReais> double devolveMaior(T dr, E it) {
        double maior = dr.get(0);
        double tmp;
        while (it.hasNext()){
            tmp = it.next();
            if(tmp > maior)
                maior = tmp;
        }
        return maior;
    }
}
