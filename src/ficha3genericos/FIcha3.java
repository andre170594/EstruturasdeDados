package ficha3genericos;

// GENERICOS REVIEW
// Imaginando que T são Triangulos, fazendo uma lista de <? super T>
// a esta lista posso adicionar todas as classes acima de triangulo (Figura < Desenho < Quadro)  * smp a subir *
// enquanto que se a lista fosse <? extends T>
// apenas poderia adicionar classes derivadas de T (linha > ponto)                               * smp a descer *

// <? super T>    -> aqui limita por baixo
// <? extends T>  -> aqui limita por cima

public class FIcha3 {
    // ex1
    public static <T,E extends T>  boolean  checkRepetido( T[] tabela, E chave){

        int cnt = 0;
        for(T val : tabela){
            if(val == chave)
                cnt++;
            if(cnt > 1)
                break;
        }
        return cnt > 1;
    }
    // ex2
    public static <T extends Comparable<T>, E extends T> boolean checkRepetidos2(T[] tabela, E chave){
        // como ambos os genéricos são comparaveis,
        // usando a função compareTo consigo implementar pesquisa binaria

        int limInf = 0, limSup = tabela.length -1;
        int meio = (limInf + limSup) / 2;

        do{
            if(tabela[meio].compareTo(chave) == 0)
                return true;
            if(tabela[meio].compareTo(chave) < 0)
                limInf = meio + 1 ;
            if(tabela[meio].compareTo(chave) > 0)
                limSup = meio - 1;

            meio = (limSup + limInf) / 2;
        }while(limSup > limInf);

        return false;

    }
    // ex3
    public static int comparaFigs(Figura A, Figura B){
        // a Class Figura faz dá extend de Comparable por isso posso usar compTO
        return A.compareTo(B);
    }
    public static int comparaRecObj(Rectangulo A, Comparable<? super Rectangulo> obj){
        return obj.compareTo(A);
    }
    public static <T> int comparadorGen(T obj, Comparable<? super T> obj2){
        return obj2.compareTo(obj);
    }
    // ex4
    public static <T extends Comparable<T>, E extends T> boolean searchMaior(T[] tab, E val){
        for(T t : tab){
            if(t.compareTo(val) > 0 )
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        // testes ex1
        System.out.println("TESTES EX1");
        Integer[] tabs = {1,2,1,3,4};
        System.out.println("chave: " + 1 + " Repetidos: " + checkRepetido(tabs,1));

        // testes ex2
        System.out.println("\nTESTES EX2");
        Double[] tabsD ={1.1,2.2,1.1,3.3,4.4};
        System.out.println("chave: " + 1.1 + " Repetidos: " + checkRepetidos2(tabsD, 1.1));

        // testes ex3A
        System.out.println("\nTESTES EX3");
        Rectangulo retA = new Rectangulo(5,6);
        Rectangulo retB = new Rectangulo(3,4);
        Figura fig = new Figura();

        System.out.println(retA);
        System.out.println(retB);
        System.out.println("A == B ?: " +  comparaFigs(retA,retB));
        System.out.println("A == B ?: " +  comparaFigs(retA,fig));
        // ex3B
        System.out.println("A == B ?: " +  comparaRecObj(retA,retB));
        System.out.println("A == B ?: " +  comparaRecObj(retA,fig));


        // testes ex4
        System.out.println("\nTESTES EX4");
        String[] nomesTab = {"Jaffar", "Akbar", "Imotep", "balbz"};
        System.out.println(searchMaior(nomesTab,"zzzz"));
        System.out.println(searchMaior(nomesTab,"aaaa"));

        Integer[] tabsInts = {1,2,3,4,10};
        System.out.println(searchMaior(tabsInts,9));
        System.out.println(searchMaior(tabsInts,15));

        // testes ex5
        System.out.println("\nTESTES EX5");
        Ponto<Integer,Integer> p = new Ponto<>(3,4);
        Ponto<Number,Number> x = new Ponto<>(0,0);
        System.out.println("p"+ p);
        System.out.println("x" + x);

        x.copy(p);
        System.out.println("x" + x);

        //Ponto<String,Integer> erro = new Ponto<String, Integer>("erro", 5);


    }
}
