package testemoodle2;

// TESTE 2 - 10/12/2018

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static java.lang.Thread.sleep;


public class exercico1 {
    public static void main(String[] args) throws InterruptedException {

//        GestorJogosFutebol gestor = new GestorJogosFutebol();
//
//        gestor.defineJogo("SLB","FCP",1000);
//        gestor.defineJogo("SLB","SCP",2000);
//        gestor.defineJogo("SLB","BRAGA",1500);
//        gestor.defineJogo("SCP","SLB",3000);
//        gestor.defineJogo("SCP","FCP",2500);
//        gestor.defineJogo("FCP","BRAGA",4000);
//
//        System.out.println("ASSIST TOTAL SLB EM CASA: " + gestor.getAssistenciaTotalEmCasa("SLB"));
//        List<String> list = gestor.getEquipasVisi("SCP");
//        for (String str: list) {
//            System.out.println(str);
//        }
//
//
//
//        GestorCidades gest = new GestorCidades();
//        gest.defineCidade("Coimbra",5000);
//        gest.defineCidade("Aveiro",6000);
//        gest.defineCidade("Porto",4500);
//        gest.defineCidade("Lisboa",15000);
//        gest.defineCidade("Leiria",8500);
//
//
//        System.out.println("\n\npop coimbra: " + gest.getPopulacao("Coimbra"));
//        System.out.println("pop Lisboa: " + gest.getPopulacao("Lisboa"));
//        gest.migracao("Coimbra","Lisboa",500);
//
//        System.out.println("pop coimbra: " + gest.getPopulacao("Coimbra"));
//        System.out.println("pop Lisboa: " + gest.getPopulacao("Lisboa"));
//
//
//        GestorEncomendas ge = new GestorEncomendas();
//        ge.add(false,new Date());
//        sleep(1000);
//        ge.add(false,new Date());
//        sleep(1000);
//        ge.add(true,new Date());
//        sleep(1000);
//        ge.add(true,new Date());
//
//        for (GestorEncomendas.Encomenda encomenda : ge.pq) System.out.println(encomenda);



        gestorTeste2 gt2 = new gestorTeste2(10);
        gt2.add(3);
        gt2.add(4);
        gt2.add(188);
        gt2.add(10);
        gt2.add(20);
        gt2.add(15);

        gt2.show();
        gt2.removaAntecessor();
        System.out.println("\n");
        gt2.show();
        gt2.removeSucessor();
        System.out.println("\n");
        gt2.show();

    }
}
