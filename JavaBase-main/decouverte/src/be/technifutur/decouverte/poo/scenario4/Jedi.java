package be.technifutur.decouverte.poo.scenario4;

public class Jedi extends Rebelle implements Force{

    public Jedi(String nom){
        super(nom);
    }

    @Override
    public void combattre(){
        System.out.println("Je combat comme un Jedi");
    }

    @Override
    public void utiliseForce(){
        System.out.println(" J'utilise le bon cote de la force");
    }

}
