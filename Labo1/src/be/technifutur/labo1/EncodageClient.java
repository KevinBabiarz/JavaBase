package be.technifutur.labo1;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;
public class EncodageClient {
    ArrayList<Personne> personnesList = new ArrayList<>();
    TableauParticipants tabParticip = new TableauParticipants();

    //Entrée des guest

    public Runnable encodage()  {
        return () -> {
            boolean retry = true;

            while(retry) {
                try {
                    boolean another = true;
                    char choix;
                    while (another) {

                        String nom;
                        String prenom;
                        String club;

                        Scanner scan = new Scanner(System.in);

                        do {
                            System.out.println("Nom: ");
                            nom = scan.nextLine();
                            System.out.println("Prenom: ");
                            prenom = scan.nextLine();
                        }while(prenom == null || nom == null || prenom.isBlank() || nom.isBlank());

                        System.out.println("Club: ");
                        club = scan.nextLine();

                        Personne personne = new Personne(nom, prenom, club);

                        tabParticip.push(personne);
                        personnesList.add(personne);

                        System.out.println("Do you want to insert another guest? Y/N");
                        choix = scan.nextLine().charAt(0);
                        if (choix == 'n') {
                            another = false;
                        }
                        retry = false;

                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.err.println("Entrez vos valeurs correctement");
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
