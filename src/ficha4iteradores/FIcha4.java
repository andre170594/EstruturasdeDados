package ficha4iteradores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FIcha4 {

    // ex7
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

    // ex8
    public static <T extends Comparable<? super T>> T devolveMaiorGEN(Iterable<T> dr){
        Iterator<T> it = dr.iterator();
        T maior,tmp;
        maior =  it.next();

        while (it.hasNext()){
            tmp =  it.next();
            if(tmp.compareTo(maior) > 0)
                maior = tmp;
        }
        return maior;
    }




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


        ArrayList<Integer> tabsInt = new ArrayList<>();
        tabsInt.add(1);
        tabsInt.add(2);
        tabsInt.add(3);
        tabsInt.add(4);
        tabsInt.add(5);

        System.out.println("MaiorGEN:" + devolveMaiorGEN(tabsInt));
    }


}
