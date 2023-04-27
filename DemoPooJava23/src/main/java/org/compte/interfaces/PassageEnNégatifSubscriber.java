package org.compte.interfaces;

import org.compte.models.Compte;

public interface PassageEnNégatifSubscriber {

    void execute(Compte c);
}
