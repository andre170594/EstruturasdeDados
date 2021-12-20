package ficha4iteradores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        ItDezReais it = (ItDezReais) dr.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
        it.resetIt();
        System.out.println("Maior:" + devolveMaior(dr));

        DezReaisMutavel drm = new DezReaisMutavel();
        drm.acrescenta(1.1);
        drm.acrescenta(2.1);
        drm.acrescenta(3.1);
        drm.acrescenta(4.1);
        drm.acrescenta(10.1);
        drm.acrescenta(6.1);

        System.out.println("Maior:" + devolveMaior(drm));

        ArrayList<Double> tabs = new ArrayList<>();
        tabs.add(2.2);
        tabs.add(5.2);
        tabs.add(3.2);
        tabs.add(1.2);
        tabs.add(7.2);
        System.out.println("Maior:" + devolveMaior(tabs));
    }

    public static Double devolveMaior(Iterable<Double> dr){
        Iterator<Double> it = dr.iterator();
        Double maior,tmp;
        maior = it.next();

        while (it.hasNext()){
            tmp = it.next();
            if(tmp > maior)
                maior = tmp;
        }
        return maior;
    }
}
