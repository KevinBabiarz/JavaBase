package be.technifutur.labo1;

import java.util.ArrayList;
import java.util.List;


public class RechercheActivite {

    /*public static void main(String[] args) {
        RechercheActivite rechercheActivite = new RechercheActivite();
        rechercheActivite.rechercheActi("mma");
    }*/

    public void rechercheActi(String userInput) {

        List<Activites> listClone = new ArrayList<Activites>();
        for (Activites activites : TableauActivites.listeActivites) {
            if (activites.getNom().equalsIgnoreCase(userInput)) {
                listClone.add(activites);
            }
        }
        listClone.forEach(activites -> System.out.println(activites.getNom()));

    }
}
