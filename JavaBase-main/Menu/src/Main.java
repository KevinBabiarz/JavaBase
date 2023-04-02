import be.technifutur.menu.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {

        //Menu menuPrincipal = getMenu();
        MenuBuilder menuBuilder = new MenuBuilder();
        Menu menuPrincipal = menuBuilder.start("Menu Principal");
        {
            menuBuilder.addItem("a", "Option1", getOption1());
            menuBuilder.startMenu("b", "Menu Secondaire");
            {
                menuBuilder.addItem("c", "Option2", getOption2());
                Menu menu3 = menuBuilder.startMenu("d", "Menu 3",new InlineVue());
                {
                    menuBuilder.addItem("e", "Option3", getOption3());
                    menuBuilder.addItem("q", "Option1", () -> menuPrincipal.setFinish(true));
                }
                menuBuilder.endMenu();
            }
            menuBuilder.endMenu();
            menuBuilder.addItem("q", "Option1", () -> menuPrincipal.setFinish(true));
        }menuBuilder.end();

        while (!menuPrincipal.isFinish()){
            menuPrincipal.execute();
        }

    }

    private static Menu getMenu(){
        Menu menuPrincipal = new Menu("Menu Principal", new MenuVueImpl());
        Menu menuSecondaire = new Menu("Menu Secondaire", new MenuVueImpl());
        ItemExecutable option1 = new ItemExecutable("Option 1", getOption1());
        ItemExecutable option2 = new ItemExecutable("Option 2", getOption2());
        ItemExecutable option3 = new ItemExecutable("Option 3", getOption3());
        ItemExecutable option4 = new ItemExecutable("Option 4", getOption4());
        ItemExecutable option5 = new ItemExecutable("Option 5", getOption5());
        menuSecondaire.addItem("a", option3);
        menuSecondaire.addItem("b", option4);
        menuPrincipal.addItem("i",option1);
        menuPrincipal.addItem("s",menuSecondaire);
        menuPrincipal.addItem("j", option2);
        menuPrincipal.addItem("k", option5);
        menuPrincipal.addItem("g",new ItemExecutable("quitter",()->menuPrincipal.setFinish(true)));

        return menuPrincipal;
    }

    private static Runnable getOption5() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Vous avez choisi l'option 5");
            }
        };
    }

    private static Runnable getOption4() {
        return()->System.out.println("Vous avez choisi l'option 4");

    }

    private static Runnable getOption3() {
        return()->System.out.println("Vous avez choisi l'option 3");

    }

    private static Runnable getOption2() {
        return()->System.out.println("Vous avez choisi l'option 2");
    }

    private static Runnable getOption1() {
        return()->System.out.println("Vous avez choisi l'option 1");
    }
}