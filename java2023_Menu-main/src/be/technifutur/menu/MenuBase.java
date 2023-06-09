package be.technifutur.menu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MenuBase extends Item implements Menu {

    private Map<String,Item> itemMap= new LinkedHashMap<>();
    private MenuVue vue;

    private boolean finish = false;
    public MenuBase(String libel, MenuVue vue) {
        super(libel);
        Objects.requireNonNull(vue);
         this.vue = vue;
    }

    @Override
    public boolean isFinish() {
        return finish;
    }

    @Override
    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public MenuVue getVue() {
         return vue;
    }

    public void setVue(MenuVue vue) {
        Objects.requireNonNull(vue);
        this.vue = vue;
    }

    public Item addItem(String key, Item value) {
        return itemMap.put(key, value);
    }

    @Override
    public void execute() {
        String choix = vue.getchoice(this);
        while( ! itemMap.containsKey(choix)){
            choix = vue.getchoice(this);
        }
        itemMap.get(choix).execute();
    }

    @Override
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
