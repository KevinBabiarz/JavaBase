package be.technifutur.decouverte.poo.scenario3;

public abstract class VaisseauAncetre {

    private static int nbEnVol = 0;

    //Variables d'instance (contiennent l'état de l'objet)
    // initialisée par defaut a la valeur par defaut du type
    private String nom; // = "OVNI";
    private int nbMissile;
    private int maxMissile;
    private boolean atteri;
    private boolean enVol = false;

    //constructeur
    public VaisseauAncetre(int maxMissile, String nom){
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
        return VaisseauAncetre.nbEnVol;
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
            VaisseauAncetre.nbEnVol++;
            System.out.println("Décollage reussi");
        }

    }

    public void atterir(){

        if(! enVol){
            System.out.println("erreur");
        }else{
            enVol = false;
            VaisseauAncetre.nbEnVol--;
            System.out.println("atterissage reussi");
        }

    }

    @Override
    public String toString() {
        return "VaisseauAncetre{" +
                "nom='" + nom + '\'' +
                ", nbMissile=" + nbMissile +
                ", maxMissile=" + maxMissile +
                ", atteri=" + atteri +
                ", enVol=" + enVol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VaisseauAncetre that = (VaisseauAncetre) o;

        if (maxMissile != that.maxMissile) return false;
        return nom.equals(that.nom);
    }

    @Override
    public int hashCode() {
        int result = nom.hashCode();
        result = 31 * result + maxMissile;
        return result;
    }

    public abstract void afficheCamps();
}
