package be.technifutur.labo1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Activites {

    public String nom;
    public LocalDateTime debut, fin;

    public Activites(String nom, LocalDateTime debut, LocalDateTime fin){
        this.nom = nom;
        this.debut = debut;
        this.fin = fin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }
}
