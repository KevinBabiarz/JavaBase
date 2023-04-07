package be.technifutur.labo1;

import java.util.ArrayList;

public class TableauParticipants {

    static ArrayList<Personne> listeParticipants = new ArrayList();
    //
    public void createList(){

        Personne personneTest = new Personne("Bab", "kev", "tennis");
        listeParticipants.add(personneTest);
        listeParticipants.add(new Personne("Dch", "Ad", "foot"));
        listeParticipants.add(new Personne("Herve", "Dumont", "basket"));
        listeParticipants.add(new Personne("Dupont de ligones", "Xavier", "foot"));
    }

    public void push(Personne personne){

        listeParticipants.add(personne);
    }

    public void afficheList(){

        for (Personne personnes : listeParticipants) {
            System.out.printf("| %s | %s | %s | %n",
                    personnes.nom,
                    personnes.prenom,
                    personnes.club);
            System.out.println();
        }
    }
}
