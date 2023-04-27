package org.example.properties;

import lombok.Getter;
import org.example.utils.Dice;

import java.util.HashMap;
import java.util.Map;
public class Stats {

    @Getter
    private final Map<StatType,Integer> stats;

    public Stats() {
        this.stats = new HashMap<>();
    }

    public Integer getStat(StatType stat){

        if(!stats.containsKey(stat))
            return 0;
        return stats.get(stat);
    }

    private void setStat(StatType stat, Integer value){

        stats.put(stat,value < 0 ? 0 : value);
    }

    public void appendStat(StatType stat, Integer value){

        stats.put(stat,getStat(stat) + value);
    }

    public void generate(){

        for(StatType s : StatType.values()){
            if (s != StatType.hp && s != StatType.sp)
             setStat(s, Dice.D6.throwDices(5,3));
        }
    }
    public void generateHpSp(){
        setStat(StatType.hp,getStat(StatType.strength) + getStat(StatType.vigor));
        setStat(StatType.sp,getStat(StatType.intelligence) + getStat(StatType.mind));
    }
    public Integer modifier(StatType stat){
        if(getStat(stat) > 15)
            return 3;
        if (getStat(stat) >10)
            return 2;
        if (getStat(stat) >5)
            return 1;

        return 0;
    }
}
