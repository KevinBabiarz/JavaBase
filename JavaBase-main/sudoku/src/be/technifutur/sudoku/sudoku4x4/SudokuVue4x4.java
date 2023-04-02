package be.technifutur.sudoku.sudoku4x4;


import be.technifutur.sudoku.AbstractSudokuVue;
import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.SudokuVue;

public class SudokuVue4x4 extends AbstractSudokuVue implements SudokuVue {
    private static String format = """
            +-----+-----+
            | . . | . . |
            | . . | . . |
            +-----+-----+
            | . . | . . |
            | . . | . . |
            +-----+-----+""".replace(".","%s");

     public SudokuVue4x4(SudokuModel4x4 leModel){
        super(format,leModel);
    }
}
