package be.technifutur.decouverte.poo.scenario1;

public class scenario1 {
    public static void main(String[] args){
        Vaisseau v1 = new Vaisseau();
        v1.nom = "Xwing";
        v1.nbMissile = -5;

        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.tirer();

        System.out.println(v1.nbMissile);
    }
}
