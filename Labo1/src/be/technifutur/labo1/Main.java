package be.technifutur.labo1;


import be.technifutur.labo1.Menu.*;

public class Main {
    public static void main(String[] args) {

        TableauParticipants.createList();
        TableauActivites.createList();

        //Menu menuPrincipal = getMenu();
        MenuBuilder menuBuilder = new MenuBuilder();
        Menu menuPrincipal = menuBuilder.start("Menu Principal");
        {
            menuBuilder.addItem("a", "Inscription", getOption1());
            menuBuilder.startMenu("b", "Menu Info");
            {
                menuBuilder.addItem("a", "Liste générale des participants", getOption2());
                menuBuilder.addItem("b", "Horaires des activités", getOption3());
                menuBuilder.addItem("c", "Liste des participants par activité", getOption4());
                //menuBuilder.addItem("q", "Quitter", () -> menuPrincipal.setFinish(true));
                menuBuilder.endMenu();
            }
            menuBuilder.addItem("c", "Gestion des activités", getOption5());
            menuBuilder.addItem("q", "Quitter", () -> menuPrincipal.setFinish(true));

        }
        menuBuilder.end();

        while (!menuPrincipal.isFinish()) {
            menuPrincipal.execute();
        }

    }

   /* private static Menu getMenu() {
        Menu menuPrincipal = new Menu("Menu Principal", new MenuVueImpl());
        Menu menuSecondaire = new Menu("Menu Secondaire", new MenuVueImpl());
        ItemExecutable option1 = new ItemExecutable("Option 1", getOption1());
        ItemExecutable option2 = new ItemExecutable("Option 2", getOption2());
        ItemExecutable option3 = new ItemExecutable("Option 3", getOption3());
        ItemExecutable option4 = new ItemExecutable("Option 4", getOption4());
        ItemExecutable option5 = new ItemExecutable("Option 5", getOption5());
        menuSecondaire.addItem("a", option3);
        menuSecondaire.addItem("b", option4);
        menuPrincipal.addItem("i", option1);
        menuPrincipal.addItem("s", menuSecondaire);
        menuPrincipal.addItem("j", option2);
        menuPrincipal.addItem("k", option5);
        menuPrincipal.addItem("g", new ItemExecutable("quitter", () -> menuPrincipal.setFinish(true)));

        return menuPrincipal;
    }*/

    private static Runnable getOption5() {
        return () -> {
               GestionActivites ga = new GestionActivites();
               ga.ajoutActivite().run();

               TableauActivites.afficheList();
                //ga.afficheList();
        };
    }

    private static Runnable getOption4() {
        return () -> System.out.println("Vous avez choisi l'option 4");

    }

    private static Runnable getOption3() {
        return () -> {

        };

    }

    private static Runnable getOption2() {
        return () -> {
            TableauParticipants.afficheList();
        };
    }


    private static  Runnable getOption1() {
        return() -> {
            EncodageClient ec = new EncodageClient();
            ec.encodage().run();

           ec.afficheList();
        };


    }


}