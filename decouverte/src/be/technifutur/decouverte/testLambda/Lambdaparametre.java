package be.technifutur.decouverte.testLambda;

import be.technifutur.decouverte.poo.scenario1.Vaisseau;
import be.technifutur.decouverte.poo.scenario2.VaisseauSecurise;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdaparametre {

    public static void main(String[] args) {
        new VaisseauSecurise(10,"v1");
        volEsquadrille(VaisseauSecurise::new);
        volEsquadrilleInconnue(VaisseauSecurise::new);
        VaisseauSecurise v1 = new VaisseauSecurise(10);
        volEsquadrilleInconnue(zorro->v1);

        volEsquadrilleInconnue(new Function<Integer, VaisseauSecurise>() {
            @Override
            public VaisseauSecurise apply(Integer zoro) {
                return v1;
            }
        });
    }

    public static void volEsquadrilleInconnue(Function<Integer, VaisseauSecurise> dede){
        for (int i = 0; i < 10; i++) {
            VaisseauSecurise v = dede.apply(10);
            System.out.println(v.getNom());
            v.decoller();
        }
    }
    public static void volEsquadrille(BiFunction<Integer, String, VaisseauSecurise> toto){

        for (int i = 0; i < 10; i++) {
            VaisseauSecurise v = toto.apply(10,"vaisseau"+i);
            System.out.println(v.getNom());
            v.decoller();
        }
    }
}
