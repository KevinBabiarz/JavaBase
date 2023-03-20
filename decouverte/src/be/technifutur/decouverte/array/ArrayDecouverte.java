package be.technifutur.decouverte.array;

import be.technifutur.decouverte.structure.MyDate;
import be.technifutur.decouverte.structure.Personne;


import java.util.Arrays;

public class ArrayDecouverte {
    public static void main(String[] args){
        int[] tab = new int[56];
        int[] tab2 = tab;

        tab[2] = 12;
        System.out.println(tab2[2]); // affiche 12
        tab = new int[2]; // changer de tableau

        int[] tab3 = new int[]{4,5,6};
        tab3 = new int[]{4,5,6};

        int[] tab4 = {4,5,6}; // alternative au tab3
        //tab4 = new int[]{4,5,6};

        System.out.println(Arrays.toString(tab4));

        int[][] tab2d = new int [3][2];// 3 tableaux de 2
        tab = tab2d [2];
        tab[1] = 5;

        System.out.println(tab2d[2][1]);// 5

        int[][] tab2d2 = new int[3][];
        tab2d2[0] = new int[5];
        tab2d2[1] = tab3;
        tab2d2[2] = tab2d2[0];

        Arrays.deepToString(tab2d2);

        int[][] tab2d3 = {{1,2}, {5,4,3}};

        for (int i = 0; i < tab2d3.length-1; i++){
            for (int j = 0; tab2d3[i]!=null && j < tab2d3[1].length-1;j++){
                System.out.println(tab2d3[i][j]);
            }
        }

        for (int[]t:tab2d3){
            for (int val: t){
                System.out.println(t);
            }
        }

        for (int i = 0; i < tab2d3.length; i++) {
            int[] t = tab2d3[i];
            for (int j = 0; j < t.length; j++) {
                int val = t[j];
                System.out.println(val);
            }
        }

        // tableau de structure

        Personne[] groupe = new Personne[2];
        groupe[0] = new Personne();
        groupe[0].nom = "Max";
        groupe[0].prenom = "Max";
        groupe[1] = new Personne();
        groupe[1].nom = "Hamilton";
        groupe[1].prenom = "Lewis";
        MyDate nais = new MyDate();
        nais.jour = 30;
        nais.mois = 4;
        nais.an = 2000;

        for (Personne p : groupe) {
            p.naissance = nais;
        }

        for (Personne p : groupe){
            System.out.printf("%s %s : %s/%s/%s/%n",
                    p.nom,
                    p.prenom,
                    p.naissance.jour,
                    p.naissance.mois,
                    p.naissance.an
                    );


        }


    }

}
