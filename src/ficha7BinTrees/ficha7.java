package ficha7BinTrees;

public class ficha7 {
    public static void main(String[] args) {

        BinTree<Integer> bt = new BinTree<>();


        bt.insere(15);
        bt.insere(12);
        bt.insere(16);
        bt.insere(10);
        bt.insere(25);
        bt.insere(17);
        bt.insere(30);

        System.out.println(bt.contemDados(16));

        System.out.println("\nPRINT IN ORDER");
        bt.printInOrder(bt.getRoot());
        System.out.println("\nPRINT POST ORDER");
        bt.printPostOrder(bt.getRoot());
        System.out.println("\nPRINT PRE ORDER");
        bt.printPreOrder(bt.getRoot());

        System.out.println("\nPRINT Leaves");
        bt.printLeaves(bt.getRoot());



        System.out.println("\nprofundidade\n" + bt.profundidade(25));
        System.out.println("\nProfundidade da Arvore " + bt.profundidadeArvore());


        bt.remove(17);
        System.out.println("\nPRINT PRE ORDER");
        bt.printPreOrder(bt.getRoot());


        bt.removeMenores(16);
        System.out.println("\nRemove < 16");
        bt.printPreOrder(bt.getRoot());



    }
}
