package be.technifutur.logiqueToJava;

import java.util.Scanner;

public class Split implements Runnable{
    public void run(){

        System.out.println("Split d'un texte");

        Scanner scan = new Scanner(System.in);

        String texte;
    
        System.out.println();
        System.out.println("Entrez un texte: ");

        texte = scan.nextLine();

        String[] tab = texte.split(" ");


        int i = 0;
        int j = 0;
        while (i < tab.length) {
            System.out.print("+");
            while(j < tab[i].length()){
            System.out.print("-");
            j++;
            }
            i++;
            j=0;
            
        }
        System.out.print("+");
        System.out.println();
  
        i=0;
        System.out.print("|");
        while(i < tab.length){
            
            System.out.print(tab[i] +"|");
            i++;
        }

        System.out.println();

        i=0;
        while (i < tab.length) {
            System.out.print("+");
            while(j < tab[i].length()){
            System.out.print("-");
            j++;
            }
            i++;
            j=0;
            
        }
        System.out.print("+");
        System.out.println();
        
        System.out.println();
        System.out.println();
        //-----------------------------------------------
        
        i = 0;
        j = 0;
        while (i < tab.length) {
            System.out.print("+");
            while(j < tab[i].length()){
            System.out.print("-");
            j++;
            }
            i++;
            j=0;
            
        }
        System.out.print("+");
        System.out.println();
  
        i=0;
        System.out.print("|");
        while(i < tab.length){
            
            System.out.print(tab[i] +"|");
            i++;
        }

        System.out.println();

        i=0;
        while (i < tab.length) {
            System.out.print("+");
            while(j < tab[i].length()){
            System.out.print("-");
            j++;
            }
            i++;
            j=0;
            
        }
        System.out.print("+");
        System.out.println();




    }
    
}
