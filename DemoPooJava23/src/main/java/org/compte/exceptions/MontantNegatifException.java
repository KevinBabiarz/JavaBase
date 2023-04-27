package org.compte.exceptions;

public class MontantNegatifException extends Exception{

    public MontantNegatifException() {
        super("Montant négatif");
    }

    public MontantNegatifException(String message) {
        super(message);
    }
}
