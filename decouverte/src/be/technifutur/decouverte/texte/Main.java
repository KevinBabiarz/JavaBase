package be.technifutur.decouverte.texte;

public class Main{
    public static void main(String[] args) {
            String texte1 = "Bonjour"; // var texte1 :T <- "Bonjour"
            char lettre = ' '; // var lettre :C <- ' '

            System.out.println(texte1.length()); // afficher longueur(texte1)
            System.out.println(texte1.charAt(2)); //afficher caract(texte,3)
            System.out.println(texte1.substring(3)); // afficher 
            System.out.println(texte1.substring(3,6)); //

            
            String test = "boo:and:foo";
            String[] tab = test.split(":");
            int i=0;
            while (i < tab.length) {
                System.out.print("-" + tab[i] + "-");
                i++;
            }
    }
}