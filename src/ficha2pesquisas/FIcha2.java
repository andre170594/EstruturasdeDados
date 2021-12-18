package ficha2pesquisas;

import java.util.Arrays;
import java.util.Random;

public class FIcha2 {

    public static int[] criaArrayCom(int valor, int dimensao, boolean diferentes){
        int[] m =new int[dimensao];
        if(diferentes){
            for(int i=0;i<dimensao;i++)
                m[i]=i*10;
            if((valor%10!=0)||(0>valor)||(valor>(dimensao-1)*10))
                m[0]=valor;
        }
        else{
            Random r=new Random();
            int gama= Math.max(Math.abs(valor), 10);
            for(int i=0;i<dimensao;i++)
                m[i]=r.nextInt(gama*4)-gama*2;
            m[0]=valor;
        }
        Arrays.sort(m);
        return m;
    }

    public static void mostraArrayInts(int[] tabs){
        System.out.println("TABS:");
        for (int val: tabs) {
            System.out.print("| " + val + " |");
        }
        System.out.println();
    }

    // ***** EX 1 *****
    public static boolean buscaRecursiva(int[] tabela, int chave, int limInf, int limSup){


        int meio= (limSup + limInf) / 2;
        if(tabela[limInf] == chave || tabela[limSup] == chave ||  tabela[meio] == chave     || limInf > limSup){
            return limInf <= limSup;
        }

        if(tabela[meio] < chave)
            limInf = meio +1;
         if(tabela[meio] > chave)
            limSup = meio -1;

        return buscaRecursiva(tabela,chave,limInf , limSup);
    }
    // ***** EX 2 *****
    public static boolean buscaIterativa(int[] tabs, int chave){
        int limInf = 0;
        int limSup = tabs.length-1;
        int meio = (limSup + limInf)/2;
        do{
            if(tabs[meio] == chave)
                return true;
            else if(tabs[meio] < chave)
                limInf = meio +1;
            else if(tabs[meio] > chave)
                limSup = meio -1;
            meio = (limSup + limInf)/2;
        }while (limInf < limSup);

        return tabs[meio] == chave;
   }
    // ***** EX 3 *****
    public static int buscaEx3(int[] tabs, int chave){
        int limInf = 0, limSup = tabs.length-1;
        int meio = (limSup+limInf)/2;

        do{
            if(tabs[meio] == chave)
                return meio;
            if(tabs[meio] < chave)
                limInf = meio + 1;
            if(tabs[meio] > chave)
                limSup = meio -1;

            meio = (limSup+limInf) /2;

        }while (limInf < limSup);

        return tabs[meio] == chave ? meio : -1;
    }
    // ***** EX4 *****
    public static int buscaBinIterEX4(int[] tabs, int chave){
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
    // ***** EX5 *****
    public static double buscarEX5(int[] tabs, int chave){

        int pos = buscaBinIterEX4(tabs,chave);            // fico a saber se valor existe e em que posição caso exista
        if(pos > 0){                                      // CASO EXISTA
            return (double) pos / tabs.length;            // DEVOLVE PERCENTAGEM DE VALORES INFERIORES
        }
        int posInsert = -pos -1;                          // SE O VALOR NÃO EXISTE USO A FORMULA (-x - 1)
        return posInsert/(double)tabs.length;             // O VALOR NA POS INSERÇÃO É MENOR E DEVE CONTAR
    }
    // ***** EX6 *****
    public static int buscaEX6(int[] tabs, int chave, int valInf, int valSUp){
        int posInf = buscaBinIterEX4(tabs,valInf);          // obtem index do min
        int posSup = buscaBinIterEX4(tabs,valSUp);          // obtem index do max

        if(posInf < 0)
            posInf = -posInf -1;            // devolve consoante (x - 1)
        if(posSup > 0)
            posSup = -posSup -1;            // devolve consoante (x - 1)
        else
            posSup++;
        return posSup - posInf;
    }
    // ***** EX7 *****
    public static boolean buscaEX7(int[] tabs, int chave){

        int pos = buscaBinIterEX4(tabs,chave);                              // obter posição no array

        if(pos < 0) return false;                                           // caso valor nao exista no array
        if(pos == 0) return tabs[pos] == tabs[pos + 1];                     // caso esteja no inicio do array
        if(pos == tabs.length -1) return tabs[pos] == tabs[pos - 1];        // caso esteja no final do array
        return tabs[pos] == tabs[pos -1] || tabs[pos] == tabs [pos +1];     // caso esteja no meio do array

    }
    // **** EX8 *****
    public static int buscaEX8(int[] tabs, int z){

        int pos = buscaBinIterEX4(tabs,z);                     // obter pos ou onde deve ser inserido
        if(pos == -1 || pos == 0)  return z;                   // devolve Z se elem não existir ou for o primeiro
        if(pos < 0)  pos = -pos -1;                            // caso n exista é preciso traduzir a pos onde deve ser inserido
        return tabs[pos -1];                                   // o -1 faz com que devolva o numero anterior

    }
    // **** EX9 *****
    public static int buscaEx9NegativeBinarySearch(int[] tabs, int chave){
        int min = 0, max = tabs.length -1, meio = (min + max) /2;

        do{
            if(tabs[meio] == chave) return meio;
            if(tabs[meio] * chave >=0){   // meio e chave têm o mesmo sinal
                if(tabs[meio] < chave)
                    min = meio +1;
                else
                    max = meio -1;
            }else{
                if(tabs[meio] < chave)
                    max = meio -1;
                else
                    min = meio +1;
            }
            meio = (min + max) / 2;
        }while (min < max);
        return tabs[meio] == chave ? meio: -1;

    }
    // **** EX10 *****
    public static int  buscaEX10(int[] tabs){
        int min = 0, max = tabs.length-1, meio = (min + max) / 2;
        do{
            if(tabs[meio] > meio)
                max = meio;
            else
                min = meio +1;
            meio = (min + max ) / 2;
        }while (min < max);

        return tabs[meio] > meio ? meio : -1;

    }





    public static void main(String[] args) {

        int[] tabs = criaArrayCom(5,10,true);
        mostraArrayInts(tabs);

        System.out.println(buscaRecursiva(tabs,10,0,tabs.length-1));
        System.out.println(buscaIterativa(tabs,15));
        System.out.println(buscaEx3(tabs,20));
        System.out.println(buscaBinIterEX4(tabs,15));
        System.out.println(buscarEX5(tabs,20));
        System.out.println(buscaEX6(tabs,20,0,60));
        System.out.println(buscaEX7(tabs,20));
        System.out.println(buscaEX8(tabs,60));
        System.out.println(buscaEx9NegativeBinarySearch(tabs,60));
        System.out.println(buscaEX10(tabs));


    }
}
