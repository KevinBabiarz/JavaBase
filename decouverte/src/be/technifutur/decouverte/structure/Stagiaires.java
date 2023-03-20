package be.technifutur.decouverte.structure;

import java.util.Arrays;
import java.util.Scanner;

public class Stagiaires {
    public static void main(String[] args) {
        Personne[] stagiaires = new Personne[1];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < stagiaires.length; i++){
            stagiaires[i] = new Personne();
            System.out.println("Nom: ");
            stagiaires[i].nom = scan.nextLine();
            System.out.println("Prenom: ");
            stagiaires[i].prenom = scan.nextLine();
            stagiaires[i].naissance = new MyDate();
            System.out.print("Date de naissance: ");
            System.out.print("Jour: ");
            stagiaires[i].naissance.jour = Integer.parseInt(scan.nextLine());
            System.out.print("Mois: ");
            stagiaires[i].naissance.mois = Integer.parseInt(scan.nextLine());
            System.out.print("An: ");
            stagiaires[i].naissance.an = Integer.parseInt(scan.nextLine());
        }

        for (Personne stagiaire : stagiaires) {
            System.out.printf("| %s | %s | %s/%s/%s |%n",
                    stagiaire.nom,
                    stagiaire.prenom,
                    stagiaire.naissance.jour,
                    stagiaire.naissance.mois,
                    stagiaire.naissance.an);
        }


    }
}
