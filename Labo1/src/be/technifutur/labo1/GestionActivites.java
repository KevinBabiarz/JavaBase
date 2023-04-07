package be.technifutur.labo1;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GestionActivites {

    //static ArrayList<Activites> listeActivites = new ArrayList<>();
    TableauActivites tabActi = new TableauActivites();

    public Runnable ajoutActivite(){

        return () -> {
            boolean retry = true;

            while (retry) {

                try {
                    boolean another = true;
                    char choix;
                    while (another) {

                        String nom;
                        LocalDateTime debut;
                        LocalDateTime fin;

                        Scanner scan = new Scanner(System.in);

                        System.out.println("Nom: ");
                        nom = scan.nextLine();
                        System.out.println("Debut: ");
                        debut = getDate();
                        System.out.println("Fin: ");
                        fin = getDate();

                        Activites activite = new Activites(nom, debut, fin);

                        tabActi.push(activite);
                        //listeActivites.add(activite);

                        System.out.println("Do you want to insert another activities? Y/N");
                        choix = scan.nextLine().charAt(0);
                        if (choix == 'n') {
                            another = false;
                        }
                        retry = false;
                    }
                }catch (InputMismatchException e){
                    System.err.println("Entrez des valeurs correctes ! \nAppuyer sur Entrée");
                }catch (DateTimeException e){
                    System.err.println("Valeurs invalides, réesseyez !");
                }
            }
        };
    }

    public LocalDateTime getDate() {
        boolean retry = true;
        Scanner scan;
        LocalDateTime date = null;
        while (retry) {

            try {
                int year, day, month, hour, min;
                scan = new Scanner(System.in);
                System.out.print("Année: ");
                year = scan.nextInt();
                System.out.print("Mois: ");
                month = scan.nextInt();
                System.out.print("Jour: ");
                day = scan.nextInt();
                System.out.print("Heure: ");
                hour = scan.nextInt();
                System.out.print("Minute: ");
                min = scan.nextInt();

                date = LocalDateTime.of(year, month, day, hour, min);
                retry = false;
            } catch (InputMismatchException e) {
                System.err.println("Format invalide !");
            }
        }
        return date;
    }
   /* public void afficheList(){

        for (Activites activites : listeActivites) {
            System.out.printf("| %s | %s | %s | %n",
                    activites.nom,
                    activites.debut,
                    activites.fin);
            System.out.println();
        }
    }*/
   public void recupererActivite(String choix){

       List<Personne> listClone = new ArrayList<Personne>();
       for (Personne personnes : TableauParticipants.listeParticipants) {
           if (personnes.club.equalsIgnoreCase(choix)) {
               listClone.add(personnes);
           }
       }
       for (Personne personnes: listClone) {
           System.out.printf("| %s | %s | %s | %n",
                   personnes.nom,
                   personnes.prenom,
                   personnes.club);
           System.out.println();
       }
   }
}