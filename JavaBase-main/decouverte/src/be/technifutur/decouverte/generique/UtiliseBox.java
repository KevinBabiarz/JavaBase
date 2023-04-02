package be.technifutur.decouverte.generique;

import be.technifutur.decouverte.poo.scenario3.Millenium;
import be.technifutur.decouverte.poo.scenario3.VaisseauAncetre;
import be.technifutur.decouverte.poo.scenario3.Xwing;
import be.technifutur.decouverte.structure.Personne;

public class UtiliseBox {

    public static void main(String[] args) {
        Box<VaisseauAncetre> bAncetre = new Box<>(new Millenium());
        Box<Millenium> bMillenium = new Box<>(new Millenium());
        //Box<VaisseauAncetre> b2Ancetre = new Box<>(new Personne("","",null)); // impossible
       // Box<Personne> bPersonne = new Box<>(new Personne("","",null));

        VaisseauAncetre contenu = bAncetre.getContenu();
        bAncetre.setContenu(new Xwing(2));
        manipuleAncetre(bAncetre);

        manipuleExtendAncetre(bAncetre);
        manipuleExtendAncetre(bMillenium);
        manipuleSuperAncetre(bAncetre);
       // manipuleSuperAncetre(bMillenium);



    }
    public static void manipuleAncetre(Box<VaisseauAncetre> boite){
        VaisseauAncetre contenu = boite.getContenu();
        boite.setContenu(new Millenium());
        boite.setContenu(new Xwing(2));
    }

    public static void manipuleExtendAncetre(Box<? extends VaisseauAncetre> boite){
        VaisseauAncetre contenu = boite.getContenu();
    }
    public static void manipuleSuperAncetre(Box<? super VaisseauAncetre> boite){
        //VaisseauAncetre contenu = boite.getContenu();
        boite.setContenu(new Millenium());
        boite.setContenu(new Xwing(2));
    }
}
