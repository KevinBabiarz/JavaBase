package be.technifutur.sudoku;

import java.util.Scanner;

public class SudokuController {

    private SudokuModelFactory factory;

    public SudokuController(SudokuModelFactory laFactory) {
        this.factory = laFactory;
    }

    public void start(String filename) throws SudokuException, DoublonException{

        boolean quit = false;
        String userInput = null;
        String[] userInputTab = null;
        Scanner scanner = new Scanner(System.in);
        SudokuVue vue = this.factory.getVue(filename);
        SudokuModel leModel = null;

        try {
            vue = this.factory.getVue(filename);
            leModel = vue.getModel();
            scanner = new Scanner(System.in);
            userInput = "";

        } catch (Exception e) {
            System.out.println("Fichier non valide: " + e.getMessage());
            quit = true;
        }

        while (quit == false) {
            System.out.println(vue.getScreen());

            System.out.println("Entrez une pos et une valeur ");

            userInput = scanner.nextLine();//saisir

            if (userInput.equalsIgnoreCase("q")) {
                quit = true;
                System.out.println("terminé  :siu");
            } else {

                try {
                    if (userInputTab[0].charAt(0) == '0') {
                        leModel.setValue(Integer.parseInt(userInputTab[1]) - 1, Integer.parseInt(userInputTab[2]) - 1, SudokuModel.EMPTY);
                    } else {
                        leModel.setValue(Integer.parseInt(userInputTab[1]) - 1, Integer.parseInt(userInputTab[2]) - 1, userInputTab[0].charAt(0));
                    }
                } catch (SudokuValueException sve) {
                    System.out.println(sve.getMessage());
                } catch (SudokuPositionException sudokuPositionException) {
                    System.out.println(sudokuPositionException.getMessage());
                } catch (SudokuLockException sel) {
                    System.out.println(sel.getMessage());
                }
            }
        }


    }

}
