package ficha6;

import java.util.Iterator;
import java.util.Set;

public class FIcha6 {
    public static void main(String[] args) {

        GestorImpressoras gestor = new GestorImpressoras();
        gestor.acrescentaImpressora(new Impressora("imp 1","HP","xpt1"));
        gestor.acrescentaImpressora(new Impressora("imp 2","SOUT","xpt2"));
        gestor.acrescentaImpressora(new Impressora("imp 3","PRINTF","xpt3"));
        gestor.acrescentaImpressora(new Impressora("imp 4","JaffPTR","xpt4"));

        Set<String> keys = gestor.getNomesImpressora();

        System.out.println("lista impressoras:");
        for (String key : keys)
            gestor.getPrinter(key).show();


        gestor.getPrinter("imp 3").enviaTrab(new Trabalho("tpGPS",1,300));
        gestor.getPrinter("imp 2").enviaTrab(new Trabalho("tpAMOv",1,560));
        gestor.getPrinter("imp 2").enviaTrab(new Trabalho("tpED",1,320));
        gestor.getPrinter("imp 1").enviaTrab(new Trabalho("tpPD",1,555));
        gestor.getPrinter("imp 3").enviaTrab(new Trabalho("tpPA",1,600));

        gestor.mostraFila();

        gestor.getPrinter("imp 2").imprimeTrab();
        gestor.getPrinter("imp 2").imprimeTrab();
        gestor.getPrinter("imp 3").imprimeTrab();

        System.out.println("\nDepois de mandar imprimir");
        gestor.mostraFila();


    }
}
