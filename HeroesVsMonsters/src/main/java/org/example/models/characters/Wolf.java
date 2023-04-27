package org.example.models.characters;

import org.example.properties.StatType;
import org.example.utils.Dice;

public class Wolf extends Entity{

    Integer cuir;
    public Integer getCuir() {
        return cuir;
    }
    public Wolf(){
        getStats().appendStat(StatType.dexterity, 5);
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
