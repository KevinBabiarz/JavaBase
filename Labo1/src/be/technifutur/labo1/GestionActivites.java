package be.technifutur.labo1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionActivites {



    //static ArrayList<Activites> listeActivites = new ArrayList<>();

    public Runnable ajoutActivite(){

        return () -> {
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

                TableauActivites.push(activite);
                //listeActivites.add(activite);

                System.out.println("Do you want to insert another activities? Y/N");
                choix = scan.nextLine().charAt(0);
                if (choix == 'n') {
                    another = false;
                }
            }
        };
    }
    public LocalDateTime getDate(){

        Scanner scan = new Scanner(System.in);

        LocalDateTime date;
        int year, day, month, hour, min;
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
}
