package be.technifutur.decouverte.poo.scenario3;

public class EtoileNoire {

    public void attireVaisseau(VaisseauAncetre v){
        if(v instanceof Millenium){
            attireVaisseau((Millenium) v);
        }else if(v instanceof Xwing x){
            attireVaisseau(x);
        }else {
            v.atterir();
            System.out.println("Vaisseau attiré");
            v.afficheCamps();
            v.decoller();
        }
    }


    public void attireVaisseau(Xwing x){
        x.atterir();
        System.out.println("Vaisseau attiré");
        x.afficheCamps();
        System.out.println("A vos ordres Darkvador");
        x.decoller();
    }

    public void attireVaisseau(Millenium m){
        m.atterir();
        System.out.println("Vaisseau attiré");
        m.afficheCamps();
        System.out.println("A l'aide Obiwan");
        m.tirer(3);
        m.decoller();
    }
}
