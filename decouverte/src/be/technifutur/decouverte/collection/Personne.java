package be.technifutur.decouverte.collection;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import static java.time.LocalTime.now;

public class Personne /*implements Comparable<Personne>*/ {
    private String nom;
    private String prenom;
    private LocalDate naissance;

    public Personne(String nom, String prenom, LocalDate naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getNaissance() {
        return naissance;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", naissance=" + naissance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        if (!Objects.equals(nom, personne.nom)) return false;
        if (!Objects.equals(prenom, personne.prenom)) return false;
        return Objects.equals(naissance, personne.naissance);
    }


    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (naissance != null ? naissance.hashCode() : 0);
        return result;
    }

    public int getAge() {

        return  Period.between(getNaissance(),LocalDate.now()).getYears();
    }

    public static Personne[] getPersonnes(){
        Personne p = new Personne("Dupond", "toto", LocalDate.of(1995,5,15));
        return new Personne[]{
               new Personne("Dupont", "toto", LocalDate.of(1995,5,15)),
                new Personne("Athan", "Jaune", LocalDate.of(2000,3,13)),
                new Personne("Mionel","Lessi",LocalDate.of(1989,6,24)),
                new Personne("Mionel","Lessi",LocalDate.of(1989,6,24)),
                new Personne("Neville", "Londubat",LocalDate.of(1960,5,2)),
                new Personne("Neville", "Londubat",LocalDate.of(1960,5,2)),
                new Personne("L'éponge", "Bob", LocalDate.of(1999, 6, 30)),
                new Personne("L'éponge", "Bob", LocalDate.of(1999, 6, 30)),
                new Personne("Daddy", "Tacos", LocalDate.of(2001, 6,01)),
                new Personne("Daddy", "Pakos", LocalDate.of(2003, 4,01)),
                new Personne("Daddy", "Kratos", LocalDate.of(2005, 9,01)),
                p,
                p
        };
    }
    /*
    @Override
    public int compareTo(Personne o) {
        int result;
        result = this.nom.compareTo(o.nom);
        if(result == 0) {
            result = this.prenom.compareTo(o.prenom);
        }
            if(result == 0){
                result = this.naissance.compareTo(o.naissance);
        }
        return result;
    }
     */
}
