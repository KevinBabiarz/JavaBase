package be.technifutur.labo1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TableauActivites {
    static ArrayList<Activites> listeActivites = new ArrayList();

    public static void createList(){

        Activites activiteTest = new Activites("Foot", LocalDateTime.of(2023,6,23,12,0), LocalDateTime.of(2023,6,30,17,00));
        listeActivites.add(activiteTest);
        listeActivites.add(new Activites("Tennis", LocalDateTime.of(2023,7,23,12,0), LocalDateTime.of(2023,7,30,17,00)));
        listeActivites.add(new Activites("MMA", LocalDateTime.of(2023,8,23,12,0), LocalDateTime.of(2023,8,30,17,00)));
        listeActivites.add(new Activites("mma", LocalDateTime.of(2023,8,23,12,0), LocalDateTime.of(2023,8,30,17,00)));
    }

    public static void push(Activites activites){

        listeActivites.add(activites);
    }
    public static void afficheList(){

        for (Activites activites : listeActivites) {
            System.out.printf("| %s | %s | %s | %n",
                    activites.nom,
                    activites.debut,
                    activites.fin);
            System.out.println();
        }
    }
}
