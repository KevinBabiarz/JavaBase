package be.technifutur.decouverte.poo.scenario4;

public class Soldat extends Rebelle{

    public Soldat(String nom){
        super(nom);
    }

    @Override
    public void combattre(){
        System.out.println("Je combat comme un soldat");
    }
}
