package be.technifutur.labo1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TableauActivites {
    static ArrayList<Activites> listeActivites = new ArrayList();
    public static void createList(){

        Activites activiteTest = new Activites("Foot", LocalDateTime.of(2023,6,23,12,0), LocalDateTime.of(2023,6,30,17,00));
        listeActivites.add(activiteTest);
        listeActivites.add(new Activites("Tennis", LocalDateTime.of(2023,7,23,12,0), LocalDateTime.of(2023,7,30,17,00)));
        listeActivites.add(new Activites("MMA", LocalDateTime.of(2023,8,23,12,0), LocalDateTime.of(2023,8,30,17,00)));
        listeActivites.add(new Activites("Basket", LocalDateTime.of(2023,6,23,12,0), LocalDateTime.of(2023,8,30,17,00)));
    }

    public static void push(Activites activites){

        listeActivites.add(activites);
    }

    public static void afficheListOption(){

        String choix;
        int i =1;
        for (Activites activites : listeActivites) {

            System.out.printf(i+" | %s | %s | %s | %n",
                    activites.nom,
                    activites.debut,
                    activites.fin);
            System.out.println();
            i++;
        }
    }

    public static String saisieActivite() {
        String choix;
        Scanner scan = new Scanner(System.in);

        System.out.println("Entrez le numero d'une activité: ");
        choix = scan.nextLine();

        return choix;
    }

    public static void getNomParticipant(String choix){

        Activites activite = listeActivites.get((Integer.parseInt(choix))-1);

        System.out.println("Liste des participants pour le stage de "+activite.getNom());
        System.out.println();
        //recupererActivite
        GestionActivites ga = new GestionActivites();
        ga.recupererActivite(activite.getNom());

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

    public static String choixModification(){
        String choixModif;
        String contenu;
        Scanner scan = new Scanner(System.in);

        System.out.println("Que voulez-vous modifier?");
        System.out.println();
        System.out.println("a. Nom");
        System.out.println("b. Date de debut");
        System.out.println("c. Date de fin");

        choixModif = scan.next();


        return choixModif;
    }

    public static String contenuModification() {

        Scanner scan = new Scanner(System.in);
        String contenu;

        System.out.println("Entrez la nouvelle valeur: ");

        contenu = scan.next();
        return contenu;
    }



    public static void modifActivite(String idActivite,String idModif,String contenuModif){
        Activites acti = listeActivites.get((Integer.parseInt(idActivite))-1);
        System.out.println(acti);
        if(idModif.equals("a")){
            acti.setNom(contenuModif);
            System.out.println(listeActivites.get((Integer.parseInt(idActivite))-1));
            System.out.println(acti.getNom());
        } else if (idModif.equals("b")) {
            acti.setDebut(LocalDateTime.parse(contenuModif));
            System.out.println(listeActivites.get((Integer.parseInt(idActivite))-1));
        } else if(idModif.equals("c")) {
            acti.setFin(LocalDateTime.parse((contenuModif)));
            System.out.println(listeActivites.get((Integer.parseInt(idActivite))-1));
        }
    }
}
