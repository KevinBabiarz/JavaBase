package be.technifutur.decouverte.poo.scenario2;

public class scenario2 {
    public static void main(String[] args) {
        System.out.println(VaisseauSecurise.getNbEnVol());
        VaisseauSecurise v2 = new VaisseauSecurise(10, "");
        System.out.println(v2.getNom());
        v2.addMissile(6);
        v2.removeMissile(3);
        System.out.println(v2.getNbMissile());


        v2.tirer();
        v2.tirer();
        v2.tirer();
        v2.tirer();
        v2.tirer();
        v2.tirer();

        System.out.println(v2.getNbMissile());

        v2.toString();
    }
}
