package be.technifutur.logiqueToJava;

public class NombrePremier implements Runnable {

    public void run() {
        System.out.println("Nombre Premier");

        int i = 1;
        int nb = 2;
        boolean verif = true;
        long before = 0, after = 0;
        before = System.currentTimeMillis();

        while (i <= 100) {

            for (int j = 2; j < nb - 1 && verif == true; j++) {

                if (nb % j == 0) {
                    verif = false;
                }

            }

            if (verif == true) {
                System.out.println(nb + " est un nombre premier " + i);
                i++;

            }

            verif = true;
            nb = nb + 1;

        }

        after = System.currentTimeMillis();
        System.out.println("Temps" + (after - before));
    }
}