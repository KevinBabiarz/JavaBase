package org.example.properties;

import lombok.Getter;

import java.util.Map;
public class Stats {

    @Getter
    private final Map<StatType,Integer> stats;

    public Stats(Map<StatType, Integer> stats) {
        this.stats = stats;
    }

    public Integer getStat(StatType stat){

        if(!stats.containsKey(stats))
            return 0;
        return stats.get(stat);
    }

    public void setStat(StatType stat, Integer value){

        stats.put(stat,value < 0 ? 0 : value);
    }

    public void appendStat(StatType stat, Integer value){

        stats.put(stat,getStat(stat) + value);
    }

}
