package testemoodle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class TesteB {

    // EX1
    // for (int i = 0; i < N; i++){         O(N)
    //    for(int k = 0; k<i;k++)           O(N -1)
    //          soma++;                     O(1)
    //    for(int j = 0; j<N;j++)           O(N)
    //          soma++                      O(1)
    // }

    // R: O(N) * ( O(N) * O(1)) + O(N) * O(1)) =
    //    O(N) * O(N) + O(N) * O(1) =
    //    O(N^2)


    // EX2
    public static  void mostraTabs(int[]tabs){
        for (int val:tabs) {
            System.out.print(" | " + val);
        }
        System.out.println();
    }
    public static int pesquisa(int[] tabs, int valor){

        int limInf = 0, limSup = tabs.length -1, meio=(limSup + limInf) / 2;

        do{
            if(tabs[meio] == valor)
                return meio;

            if(tabs[meio] < valor)
                limInf = meio +1;
            if(tabs[meio] > valor)
                limSup = meio -1;
            meio = (limInf+ limSup) / 2;
        }while (limInf < limSup);


        return tabs[meio] < valor ? -meio -2 : -meio -1;

    }
    public static int proximo(int[] tabs, int valor){
        int pos = pesquisa(tabs,valor);
        if (pos == tabs.length -1 || pos < 0)
            return valor;
       else
           return tabs[pos] == tabs[pos +1] ? valor : tabs[pos +1];

    }

    // EX3
    public static <T extends Comparable<? super T>> void f(ArrayList<T> lista,T valor){
        lista.removeIf(val -> val.compareTo(valor) < 0);
    }

    public static void main(String[] args) {


        int[] tabs = {10,20,30,40,50,60,70,80,90,99};
        int chave = 9;
        mostraTabs(tabs);
        System.out.println("Next maior que " + chave +": " +proximo(tabs,chave));

        Pessoa p = new Pessoa("Jaffar Akbar","Rua das Bombas");
        IterPessoas itp = (IterPessoas) p.iterator();
        while (itp.hasNext()){
            System.out.println("Nome: " + itp.next());
            System.out.println("Morada: " + itp.next());
        }


        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(20);
        lista.add(30);
        lista.add(10);
        f(lista,15);
        for (Integer integer : lista) System.out.print(" | " + integer);

        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Jaffar");
        nomes.add("Akbar");
        nomes.add("Imotep");
        nomes.add("Renas");
        nomes.add("oi");
        nomes.add("estrutura");
        nomes.add("dados");

        System.out.println();

        f(nomes,"aaaaa");
        for(String str : nomes) System.out.print(" | " + str);

    }
}
