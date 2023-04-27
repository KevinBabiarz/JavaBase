package org.example.models.characters;

import org.example.models.characters.Interfaces.RegenPersonnageSubscriber;
import org.example.properties.StatType;
import org.example.properties.Stats;
import org.example.utils.Dice;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {

    private final List<RegenPersonnageSubscriber> RegenEvent = new ArrayList<>();

    private Stats stats;
    private Integer currentHp;
    private Integer currentSp;
    public Entity(){
        this.stats = new Stats();
        this.stats.generate();
    }
    public Stats getStats() {
        return stats;
    }
    public void regen(){
        setCurrentHp(getHp());
        setCurrentSp(getSp());
    }
    public Integer getCurrentSp(){
        return currentHp;
    }
    private void setCurrentSp(Integer value){
       this.currentSp = currentSp;
    }
    public Integer getCurrentHp(){
        return currentHp;
    }
    private void setCurrentHp(Integer value){
        currentHp = value < 0 ? 0 : value > stats.getStat(StatType.hp) ? stats.getStat(StatType.hp) : value;
    }
    public Integer getHp(){
        return stats.getStat(StatType.hp);
    }
    public Integer getSp(){
        return stats.getStat(StatType.sp);
    }
    public Integer getStrength(){
        return stats.getStat(StatType.strength);
    }
    public Integer getVigor(){
        return stats.getStat(StatType.vigor);
    }

    public Integer getIntelligence(){
        return stats.getStat(StatType.intelligence);
    }
    public boolean isAlive() {
        return getCurrentHp() > 0;
    }

    public abstract void hit(Entity target);

    public void takeDamage(int amount){
        if(currentHp == null)
            return;
        if (amount < 0)
            return;

        setCurrentHp(getCurrentHp()-amount);

        if (!isAlive()){
            startRegenPersonnageSubscriber();
        }
    }

    public void addRegenPersonnageSubscriber(RegenPersonnageSubscriber subscriber){
        RegenEvent.add(subscriber);
    }

    public void removeRegenPersonnageSubscriber(RegenPersonnageSubscriber subscriber){
        RegenEvent.remove(subscriber);
    }

    public void startRegenPersonnageSubscriber(){

        for (RegenPersonnageSubscriber subscriber : RegenEvent){
            subscriber.execute(this);
        }
    }
}
