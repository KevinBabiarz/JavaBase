package be.technifutur.labo1.Menu;

import java.util.ArrayDeque;
import java.util.Deque;
public class MenuBuilder {
    private MenuVue defaultVue = new MenuVueImpl();
    private MenuVue inlineVue = new InlineVue();
    private Deque<Menu> pileMenu = new ArrayDeque<>();

    public Menu getMenu() {
        return pileMenu.peek();
    }

    public Item addItem(String key, String libel, Runnable action) {
        ItemExecutable itemExecutable = new ItemExecutable(libel, action);
        pileMenu.peek().addItem(key,itemExecutable);
        return itemExecutable;
    }

    public Menu startMenu(String key, String libel){
        return startMenu(key,libel,defaultVue);
    }
    public Menu startMenu(String key, String libel, MenuVue vue) {
        Menu menu = new Menu(libel, vue);
        pileMenu.peek().addItem(key,menu);
        pileMenu.push(menu);
        return menu;
    }

    public Menu endMenu() {
        return pileMenu.pop();
    }

    public void end() {
        pileMenu.clear();
    }

    public Menu start(String menuPrincipal) {
        Menu menu = new Menu(menuPrincipal, defaultVue);
        pileMenu.push(menu);
        return menu;
    }
}
