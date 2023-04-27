package org.example.models.characters;

import org.example.properties.StatType;
import org.example.utils.Dice;

public class Dragon extends Entity{

    int gold;
    int cuir;

    public int getGold() {
        return gold;
    }

    public int getCuir() {
        return cuir;
    }
    public Dragon(){
        getStats().appendStat(StatType.strength,5);
        getStats().appendStat(StatType.intelligence,5);
        gold = Dice.D6.throwDice();
        cuir = Dice.D6.throwDice();
        getStats().generateHpSp();
        regen();
    }
    @Override
    public void hit(Entity target) {
        int damage = getStats().modifier(StatType.intelligence) + Dice.D4.throwDice();
        target.takeDamage(damage);
    }
}
