package be.technifutur.labo1;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TableauActivites {
    static ArrayList<Activites> listeActivites = new ArrayList();
    public void createList(){

        Activites activiteTest = new Activites("Foot", LocalDateTime.of(2023,6,23,12,0), LocalDateTime.of(2023,6,30,17,00));
        listeActivites.add(activiteTest);
        listeActivites.add(new Activites("Tennis", LocalDateTime.of(2023,7,23,12,0), LocalDateTime.of(2023,7,30,17,00)));
        listeActivites.add(new Activites("MMA", LocalDateTime.of(2023,8,23,12,0), LocalDateTime.of(2023,8,30,17,00)));
        listeActivites.add(new Activites("Basket", LocalDateTime.of(2023,6,23,12,0), LocalDateTime.of(2023,8,30,17,00)));
    }

    public void push(Activites activites){

        listeActivites.add(activites);
    }

    public void afficheListOption(){

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

    public String saisieActivite() {
        String choix = "";
        Scanner scan = new Scanner(System.in);
        boolean retry = true;
        while(retry){
            try {
                do {
                    System.out.println("Entrez le numero d'une activité: ");
                    choix = scan.nextLine();
                } while (Integer.parseInt(choix) > listeActivites.size());
                retry = false;
            }catch (NumberFormatException e){
                System.err.println("Entrez une valeur valide !");
            }
        }
        return choix;
    }

    public void getNomParticipant(String choix){

        Activites activite = listeActivites.get((Integer.parseInt(choix))-1);

        System.out.println("Liste des participants pour le stage de "+activite.getNom());
        System.out.println();
        //recupererActivite
        GestionActivites ga = new GestionActivites();
        ga.recupererActivite(activite.getNom());

    }

    public void afficheList(){

        for (Activites activites : listeActivites) {
            System.out.printf("| %s | %s | %s | %n",
                    activites.nom,
                    activites.debut,
                    activites.fin);
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        TableauActivites tableauActivites = new TableauActivites();
//        String choixModif = tableauActivites.choixModification();
//    }
    public String choixModification(){
        String choixModif = "";
        String contenu;
        Scanner scan = new Scanner(System.in);
        boolean retry = true;


                System.out.println("Que voulez-vous modifier?");
                System.out.println();
                System.out.println("a. Nom");
                System.out.println("b. Date de debut");
                System.out.println("c. Date de fin");
                choixModif = scan.next();
                retry = false;


        return choixModif;
    }

    public String contenuModification() {

        Scanner scan = new Scanner(System.in);
        String contenu;

        System.out.println("Entrez la nouvelle valeur: ");

        contenu = scan.next();
        return contenu;
    }

    public void modifActivite(String idActivite,String idModif){
        TableauActivites tabActi = new TableauActivites();
        boolean retry = true;
        GestionActivites ga = new GestionActivites();
        Activites acti = listeActivites.get((Integer.parseInt(idActivite))-1);
        System.out.println(acti);
        while(retry) {
            try {
                if (idModif.equals("a")) {
                    acti.setNom(this.contenuModification());
                    System.out.println(listeActivites.get((Integer.parseInt(idActivite)) - 1));
                    System.out.println(acti.getNom());
                } else if (idModif.equals("b")) {
                    acti.setDebut(ga.getDate());
                    System.out.println(listeActivites.get((Integer.parseInt(idActivite)) - 1));
                } else if (idModif.equals("c")) {
                    acti.setFin(ga.getDate());
                    System.out.println(listeActivites.get((Integer.parseInt(idActivite)) - 1));
                }
                retry = false;
            }catch (DateTimeParseException e){
                System.err.println("Entrez un format valide !");
            }
        }
    }
}
