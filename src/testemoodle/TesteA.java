package testemoodle;

public class TesteA {


    // EX 1
    // for(int i = 0; i < N; i++)               O(N)
    //     for(int j = 0; j<i;j++)              O(N-1)
    //         for(int k = 0; k< j; k++)        O(n-2)
    //              soma ++;                    O(1)

    // R:  O(N) * O(N-1) * O(N-2) * O(1) = O(N^3)

    // EX 2
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

    public static void main(String[] args) {

        int[] tabs = {10,20,20,40,50,60,60,80,90,100};
        System.out.println(maiores(tabs,20));
    }


}
