package be.technifutur.logiqueToJava;

import java.util.Arrays;
import java.util.Random;

public class recherchePosition implements Runnable{

        public void run() {

            int[] val = new int[1000000];
            Random rand = new Random();
            int nb= rand.nextInt(200);


            for (int i = 0; i < val.length; i++) {
                val[i] = rand.nextInt(200);
            }
            Arrays.sort(val);    //tri du tableau

            System.out.printf(" la valeur: %s se trouve a la position %s%n", nb, rechercheDicatomique(val, nb));

        }

            public int rechercheDicatomique(int[]tab, int val){
                int pos = -1;
                int deb = 0;
                int fin = tab.length -1;
                int milieu;

                while( deb<fin ){
                    milieu = (deb + fin) /2;
                    if(val > tab[milieu]){
                        deb = milieu + 1;
                    }else{
                        fin = milieu;
                    }
                }
                if(tab[deb]==val){
                    pos=deb;
                }
                return pos;
            }

            public int rechercheSimple(int[]tab, int val){
                int pos = -1;



                return pos;

            }


}
