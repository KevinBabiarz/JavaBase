package org.example;

import org.example.models.characters.Character;
import org.example.utils.Dice;

public class Main {
    public static void main(String[] args) {

        System.out.println(Dice.D10.throwDices(5));
    }
}