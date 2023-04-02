package be.technifutur.decouverte.exercices;

import be.technifutur.decouverte.collection.Personne;

import java.util.*;
import java.util.stream.Collectors;


public class ExerciceList {

    public static void main(String[] args) {
        // Création de la liste
        List<Personne> arrayList = Arrays.asList(Personne.getPersonnes());
        Set<Personne> newListe = new HashSet<>();
        // Affichage de celle-ci
        System.out.println(arrayList);
        //Boucle pour le remove
        arrayList.forEach(p -> {
            if (p.getAge() < 30) newListe.add(p);
        });
        // Affichage de la nouvelle liste
        //System.out.println("newListe (age < 30)= " + newListe);
        newListe.forEach(System.out::println);

        // ------------------ Stream ------------------
        System.out.println("Stream");
        //L'endroit des données
        Set<String> grands = Arrays.asList(Personne.getPersonnes())
                // Commencement
                .stream()
                // modificateur du stream
                .filter(p -> p.getAge() < 30)
                // modificateur du stream
                .map(personne -> personne.getNom() + " agé de " + personne.getAge())
                // Crée le résultat
                .collect(Collectors.toSet());
        // Affichage du résultat
        grands.forEach(System.out::println);


        long count = Arrays.asList(Personne.getPersonnes())
                .stream()
                .filter(personne -> personne.getAge() < 30)
                .count();
        System.out.println("count = " + count);
        // Optionnal
        Optional<Personne> optio = Arrays.asList(Personne.getPersonnes())
                .stream()
                .filter(personne -> personne.getAge() < 30)
                .max(Comparator.comparing(Personne::getNaissance));
        if (optio.isPresent()) System.out.println(optio.get());
        else System.out.println("nobody");

        System.out.println("+ de 7 caractères");
        List<Personne> plusDe7Caracteres = Arrays.asList(Personne.getPersonnes())
                // Commencement
                .stream()
                // modificateur du stream
                .filter(p -> p.getNom().length() > 7)
                //Enleve les doublons
                .distinct()
                // Crée le résultat
                .toList();
        // Affichage du résultat
        plusDe7Caracteres.forEach(System.out::println);

        System.out.println("sorted age nom prenom");
        List<Personne> plusDe7CaracteresSorted = Arrays.asList(Personne.getPersonnes())
                // Commencement
                .stream()
                // modificateur du stream
                .filter(p -> p.getNom().length() > 7)
                //Enleve les doublons
                .distinct()
                // triage
                .sorted(Comparator.comparing(Personne::getAge).thenComparing(Personne::getNom).thenComparing(Personne::getPrenom))
                // Crée le résultat
                .toList();
        // Affichage du résultat
        plusDe7CaracteresSorted.forEach(System.out::println);

        System.out.println("Tous le monde a plus de 20 ans");
        boolean plus20Ans = Arrays.asList(Personne.getPersonnes())
                // Commencement
                .stream()
                .allMatch(personne -> personne.getAge()>20);
        // Affichage du résultat
        System.out.println(plus20Ans);
    }
}
