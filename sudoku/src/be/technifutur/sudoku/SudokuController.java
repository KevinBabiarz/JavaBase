package be.technifutur.sudoku;

import java.util.Scanner;

public class SudokuController {

    private SudokuModelFactory factory;

    public SudokuController(SudokuModelFactory laFactory) {
        this.factory = laFactory;
    }

    public void start(String filename) {

        boolean quit = false;
        String userInput = null;
        Scanner scanner = new Scanner(System.in);
        SudokuVue vue = this.factory.getVue(filename);

        while (quit == false) {
            System.out.println(vue.getScreen());

            System.out.println("Entrez une pos et une valeur ");

            userInput = scanner.nextLine();//saisir

            if (userInput.equalsIgnoreCase("q")) {
                quit = true;
                System.out.println("terminé  :siu");
            } else {

                String stringLigne = userInput;
                int ligne = Integer.parseInt(stringLigne);

                String stringColumn = scanner.nextLine();//saisir
                int column = Integer.parseInt(stringColumn);

                String stringValue = scanner.nextLine();//saisir
                char value = stringValue.charAt(0);

                SudokuModel model = vue.getModel();
                model.setValue(ligne, column, value);

            }

        }


    }

}
