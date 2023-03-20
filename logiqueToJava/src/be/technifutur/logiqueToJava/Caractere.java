package be.technifutur.logiqueToJava;

import java.util.Scanner;

public class Caractere implements Runnable {
    public void run() {
        System.out.println("Recherche caractere");

        Scanner scan = new Scanner(System.in);

        String texte;
        char caractere;
        int cptFois = 0;
        int derPos = 0;
        int pos = 0;

        System.out.println();
        System.out.println("Entrez un texte: ");

        texte = scan.nextLine();

        System.out.println();
        System.out.println("Choisir un caractère: ");
        

        caractere = scan.nextLine().charAt(0);

        while (pos < texte.length()) {
            if (texte.charAt(pos) == caractere) {
                cptFois++;
                derPos = pos;
                if (cptFois == 1) {
                    System.out.println();
                    System.out.println("Premiere position: " + pos);
                }
            }
            pos++;

        }
        if (cptFois == 0) {
            System.out.println("La lettre n'existe pas.");
        }

        System.out.println("Apparait la derniere fois en "+derPos);
        System.out.println("Apparait "+cptFois+" fois.");
        System.out.println();

    }

}
