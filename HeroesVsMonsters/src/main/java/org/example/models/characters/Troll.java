package org.example.models.characters;

import org.example.properties.StatType;
import org.example.utils.Dice;

public class Troll extends Entity{

    int gold;
    public int getGold() {
        return gold;
    }
    public Troll(){
        getStats().appendStat(StatType.strength,5);
        gold = Dice.D6.throwDice();
        getStats().generateHpSp();
        regen();
    }
    @Override
    public void hit(Entity target) {
        int damage = getStats().modifier(StatType.intelligence) + Dice.D4.throwDice();
        target.takeDamage(damage);
    }
}
