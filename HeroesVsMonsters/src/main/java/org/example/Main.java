package org.example;

import org.example.models.characters.Dragon;
import org.example.models.characters.Warrior;
import org.example.utils.Dice;

public class Main {
    public static void main(String[] args) {

        Warrior w = new Warrior("Rocky");
        Dragon d = new Dragon();

        d.addRegenPersonnageSubscriber(monstre -> w.loot(monstre));
//      d.addRegenPersonnageSubscriber(monstre :: loot));

        while(w.isAlive() && d.isAlive()){

            w.hit(d);

            if(d.isAlive())
                d.hit(w);

            System.out.println("Hero : " + w.getCurrentHp() + "\nMonstre : " + d.getCurrentHp() );

        }
        System.out.println("Gold: " + w.getGold());
        System.out.println("Leather: " + w.getCuir());

    }
}