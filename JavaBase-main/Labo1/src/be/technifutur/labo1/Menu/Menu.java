package be.technifutur.labo1.Menu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Menu extends Item{

    private Map<String,Item> itemMap = new LinkedHashMap<>();

    private MenuVue vue;

    private boolean finish = false;

    public Menu(String libel, MenuVue vue){
        super(libel);
        Objects.requireNonNull(vue);
        this.vue = vue;
    }

    public MenuVue getVue(){
        return null;
    }
    public MenuVue setVue() {
        Objects.requireNonNull(vue);
        return vue;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public Item addItem(String key, Item value) {
        return itemMap.put(key, value);
    }

    public Menu(String libel){
        super(libel);
    }
    @Override
    public void execute() {
        String choix = vue.getchoice(this);
        while( ! itemMap.containsKey(choix)){
            choix = vue.getchoice(this);
        }
        itemMap.get(choix).execute();

    }

    public Map<String, String> getItemText() {
        return this.itemMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().getLibel(),
                        (a,b)->a+b,
                        LinkedHashMap::new
                ));
    }
}