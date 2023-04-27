package org.example.models.characters;

import org.example.properties.StatType;
import org.example.utils.Dice;

public class Mage extends Entity{

    private String name;
    private int gold = 0;
    private int cuir = 0;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getCuir() {
        return cuir;
    }

    public void setCuir(int cuir) {
        this.cuir = cuir;
    }
    public Mage(String name){
        this.name = name;
        getStats().appendStat(StatType.intelligence,5);
        getStats().appendStat(StatType.mind,5);
    }
    public String getName(){
        return name;
    }
    @Override
    public void hit(Entity target) {
        int damage = getStats().modifier(StatType.intelligence) + Dice.D4.throwDice();
        target.takeDamage(damage);
    }
    public void loot(Entity target){
        regen();
        if (target instanceof Dragon d){
            setGold(getGold() + d.getGold());
            setCuir(getCuir() + d.getCuir());
        }
    }
}
