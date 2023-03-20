package be.technifutur.decouverte.poo.scenario4;

public class Sith extends Empire implements Force{

    public Sith(String nom){
        super(nom);
    }

    @Override
    public void combattre(){
        System.out.println("Je combat comme un Sith");
    }

    @Override
    public void utiliseForce(){
        System.out.println("J'utilise le mauvais cote de la force");
    }
}
