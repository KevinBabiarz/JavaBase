package org.example.properties;

import lombok.Getter;
import org.example.utils.Dice;

import java.util.HashMap;
import java.util.Map;

public class BaseProperty<TKey,TValue>{

    @Getter
    protected final Map<TKey,TValue> properties;

    public BaseProperty(){
        this.properties = new HashMap<>();
    }


    public TValue getProperty(TKey key){

        if(!properties.containsKey(key))
            throw new RuntimeException();
        return properties.get(key);
    }

    public void setProperty(TKey key, TValue value){

        properties.put(key,value);
    }


}
