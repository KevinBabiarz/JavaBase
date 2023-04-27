package org.compte.models;

import org.compte.exceptions.MontantNegatifException;
import org.compte.exceptions.SoldeInsuffisantException;
import org.compte.interfaces.PassageEnNégatifSubscriber;

import java.util.ArrayList;
import java.util.List;

public class Compte {

    private final List<PassageEnNégatifSubscriber> passageEnNégatifEvent = new ArrayList<>();



    private String numero;
    private double solde;



    private double ligneDeCredit;

    public Compte(String numero, double ligneDeCredit){

        this.numero = numero;
        this.ligneDeCredit = ligneDeCredit;
        this.solde = 0;
    }

    public double getLigneDeCredit() {
        return ligneDeCredit;
    }

    public void setLigneDeCredit(double ligneDeCredit) throws MontantNegatifException {

        if (ligneDeCredit < 0)
            throw new MontantNegatifException("Ligne de Credit doit etre positive");
        this.ligneDeCredit = ligneDeCredit;
    }

    private void setSolde(double solde){

        this.solde = solde;
    }

    public double getSolde() {

        return solde;
    }

    public void retrait(double montant) throws Exception {

        double ancienSolde = getSolde();

        if (montant < 0)
            throw new MontantNegatifException("Le montant doit etre positif");
        if (solde - montant < -getLigneDeCredit())
            throw new SoldeInsuffisantException();

        setSolde(getSolde() - montant);

        if(ancienSolde > 0 && getSolde() < 0)
            raisePassageEnNegatifEvent();
    }

    public void depot(double montant) throws Exception {
        if (montant < 0)
            throw new MontantNegatifException();

        setSolde(getSolde() + montant);

    }

    public void addPassageEnNegatifSubscriber(PassageEnNégatifSubscriber subscriber){

        passageEnNégatifEvent.add(subscriber);
    }

    public void removePassageEnNegatifSubscriber(PassageEnNégatifSubscriber subscriber){

        passageEnNégatifEvent.remove(subscriber);
    }

    public void raisePassageEnNegatifEvent(){

        for (PassageEnNégatifSubscriber subscriber : passageEnNégatifEvent){

            subscriber.execute(this);
        }
    }

    public String getNumero() {
        return numero;
    }
}
