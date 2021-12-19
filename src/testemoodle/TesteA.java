package testemoodle;

import java.util.ArrayList;
import java.util.ListIterator;

public class TesteA {


    // EX1
    // for(int i = 0; i < N; i++)               O(N)
    //     for(int j = 0; j<i;j++)              O(N-1)
    //         for(int k = 0; k< j; k++)        O(n-2)
    //              soma ++;                    O(1)

    // R:  O(N) * O(N-1) * O(N-2) * O(1) = O(N^3)

    // EX2
    public static int pesquisa(int[] tabs, int chave){
        int limInf= 0, limSup = tabs.length -1;
        int meio = (limSup + limInf) /2;
        do{
            if(tabs[meio] == chave)
                return meio;
            if(tabs[meio] < chave)
                limInf = meio +1;
            if(tabs[meio] > chave)
                limSup = meio -1;

            meio = (limSup + limInf) /2;
        }while (limInf < limSup);

        return tabs[meio] < chave ? -meio - 2 : -meio - 1;

    }
    public static int maiores(int[] m, int valor){
        int pos = pesquisa(m,valor);        // O( Log N)
        if(pos > 0){
            if(m[pos + 1] != m[pos])
                return m.length - pos -1;
            else
                return m.length - pos - 2;
        }else {
            return m.length -(-pos -1);
        }
    }

    // EX3
    public static <T> void mostraList(ArrayList<? super T> lista){
        ListIterator<? super T> li = lista.listIterator();
        while (li.hasNext())
            System.out.print("| " + li.next());
        System.out.println();
    }
    public static <T> void f(T val, ArrayList<? super T> lista){
        lista.add(val);
    }


    // EX4


    public static void main(String[] args) {

        int[] tabs = {10,20,20,40,50,60,60,80,90,100};
        System.out.println(maiores(tabs,20));

        ArrayList<Double> list = new ArrayList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(4.0);
        list.add(5.0);
        mostraList(list);
        f(10.0,list);
        mostraList(list);


    }


}
