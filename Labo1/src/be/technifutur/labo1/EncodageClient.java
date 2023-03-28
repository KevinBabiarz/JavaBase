package be.technifutur.labo1;

import java.util.ArrayList;
import java.util.Scanner;

public class EncodageClient {
    int i = 0;
    Runnable r;

    boolean another = true;
    char choix;
    ArrayList<Personne> personnesList = new ArrayList<>();

    //Entrée des guest

    public Runnable encodage() {
        return r = () -> {
            while (another == true) {

                Scanner scan = new Scanner(System.in);

                Personne personne = new Personne();

                System.out.println("Nom: ");
                personne.nom = scan.nextLine();
                System.out.println("Prenom: ");
                personne.prenom = scan.nextLine();
                System.out.println("Club: ");
                personne.club = scan.nextLine();

                personnesList.add(personne);

                System.out.println("Do you want to insert another guest? Y/N");
                choix = scan.nextLine().charAt(0);
                if (choix == 'n') {
                    another = false;
                }

            }
        };
    }

    public void afficheList() {
            for (Personne personnes : personnesList) {
                System.out.printf("| %s | %s | %s | %n",
                        personnes.nom,
                        personnes.prenom,
                        personnes.club);
                System.out.println();
            }

    }
}
