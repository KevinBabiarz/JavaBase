package be.technifutur.decouverte.collection;

import java.time.LocalDate;
import java.util.*;

public class TestList {

    public static void main(String[] args) {
        testList(new ArrayList<>());
        testList(new LinkedList<>());
        testList(Arrays.asList(Personne.getPersonnes()));
        ArrayList<Personne> arrayList = new ArrayList<>();
        for(Personne p: Personne.getPersonnes()){
            arrayList.add(p);
        }
        List<Personne> nonModifiable = Collections.unmodifiableList(arrayList);
        testList(nonModifiable);

    }

    private static void testList(List<Personne> personnes) {
        try {
            System.out.printf(" taille : %s%n", personnes.size());
            for (Personne p : personnes) {
                System.out.println(p);
            }

            Personne element = new Personne("Duret", "Jonathan", LocalDate.now());
            //personnes.set(0, element);
            System.out.println(personnes.get(0));
           /* for (Personne p : Personne.getPersonnes()) {
                boolean add = personnes.add(p);
                System.out.println(add);
            }
            */

            personnes.remove(element);
            personnes.remove(3);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
