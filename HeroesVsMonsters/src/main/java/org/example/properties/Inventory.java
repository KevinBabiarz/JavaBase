package org.example.properties;

import lombok.Getter;
import org.example.utils.Dice;

import java.util.HashMap;
import java.util.Map;

public class Inventory extends BaseProperty<ItemType, Integer>{

    public void appendItem(ItemType item, Integer value){

        properties.put(item,getProperty(item) + value);
    }
}
