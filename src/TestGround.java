

public class TestGround {

    public static void mostraLista(int[]  lista){
        for (int val: lista) {
            System.out.print(" | " + val);
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int[] tabs = {10,20,20,40,50,60,60,80,90,100};
        mostraLista(tabs);



    }
}
