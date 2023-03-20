package be.technifutur.decouverte.poo.scenario2;

import java.util.Objects;

public class VaisseauSecurise extends Object{

    private static int nbEnVol = 0;

    //Variables d'instance (contiennent l'état de l'objet)
    // initialisée par defaut a la valeur par defaut du type
    private String nom; // = "OVNI";
    private int nbMissile;
    private int maxMissile;
    private boolean atteri;
    private boolean enVol = false;

    //constructeur
    public VaisseauSecurise(int maxMissile, String nom){
        super();
        this.maxMissile = maxMissile;
        //Objects.nonNull(nom); // provoque une erreur si c est null
        if(nom!= null && ! nom.isBlank()){
            this.nom= nom;
        }else{
            this.nom= "OVNI";
        }

    }
    //methode de classe
    public static int getNbEnVol(){
        return VaisseauSecurise.nbEnVol;
    }

    //Methodes d'instance
    public void tirer() {
        if (this.nbMissile > 0) {
            System.out.println("PAN");
            this.nbMissile--;
        } else {
            System.out.println("POUF");
        }
    }

    public int getNbMissile() {
        return this.nbMissile;
    }

    public String getNom() {
        return this.nom;
    }

    public boolean removeMissile(int nbMissile) {
        boolean accepted=false;
        if (nbMissile > 0 && this.nbMissile >= nbMissile) {
            this.nbMissile -= nbMissile;
            accepted=true;
        }
        return accepted;
    }
    public boolean addMissile(int nbMissile) {
        boolean accepted=false;
        if (nbMissile > 0 && this.nbMissile + nbMissile <= nbMissile) {
            this.nbMissile += nbMissile;
            accepted=true;
        }
        return accepted;
    }

    public void decoller(){

        if(enVol){
            System.out.println("erreur");
        }else{
            enVol=true;
            VaisseauSecurise.nbEnVol++;
            System.out.println("Décollage reussi");
        }

    }

    public void atterir(){

        if(! enVol){
            System.out.println("erreur");
        }else{
            enVol = false;
            VaisseauSecurise.nbEnVol--;
            System.out.println("atterissage reussi");
        }

    }


}
