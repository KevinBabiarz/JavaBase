package be.technifutur.logiqueToJava;

public class Listee implements Runnable {
    public void run() {
        MyList l = null;
        l=ajouterDebut(l,23);


    }

    public MyList sousList(MyList l, int position){
        MyList result = l;

        for (int i = 0; i < position ; i++) {
            result = result.suivant;
        }
        return result;
    }

    public int longueur(MyList l){
        int taille=0;

        while(l!=null){
            l = l.suivant;
            taille ++;
        }
        return taille;
    }

    public int lire(MyList l, int position){
        return sousList(l,position).valeur;
    }

    public void remplacer(MyList l, int position, int newValeur){
        sousList(l,position).valeur = newValeur;
    }

    public MyList ajouterDebut(MyList l, int newValeur){
        MyList result = new MyList();
        result.valeur = newValeur;
        result.suivant= l;
        return result;
    }

}
