package be.technifutur.sudoku.sudoku9x9;

import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.SudokuVue;

public class SudokuVue9x9 implements SudokuVue {

    private static String format = """
            +-------+-------+-------+
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            | . . . | . . . | . . . | 
            +-------+-------+-------+
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            +-------+-------+-------+
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            +-------+-------+-------+""".replace(".","%s");
    @Override
    public String getScreen() {
        return null;
    }

    @Override
    public SudokuModel getModel() {
        return null;
    }
}
