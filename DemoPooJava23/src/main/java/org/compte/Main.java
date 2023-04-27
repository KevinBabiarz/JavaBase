package org.compte;

import org.compte.exceptions.MontantNegatifException;
import org.compte.exceptions.SoldeInsuffisantException;
import org.compte.models.Compte;

public class Main {

    public static void main(String[] args) {

        Compte c = new Compte("1", 100);
        c.addPassageEnNegatifSubscriber( compte -> System.out.println(c.getNumero() + " est passé en négatif."));
        c.addPassageEnNegatifSubscriber( compte -> System.out.println("Nouveau solde " + compte.getSolde()));
        c.addPassageEnNegatifSubscriber( compte -> System.out.println("C'est quand meme pas mal..."));
        c.addPassageEnNegatifSubscriber( compte -> System.out.println("Il est capable de retenir tout ce que je veux executer"));


        try {
            c.depot(100);
            c.retrait(150);
            System.out.println("Ok");
        }
        catch(MontantNegatifException e){
            System.err.println("T'es con ou quoi");
        }
        catch (SoldeInsuffisantException e){
            System.err.println("Va travailler ou faire une formation java");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Finish");
    }
}
