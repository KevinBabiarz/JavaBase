package be.technifutur.sudoku;

public interface SudokuModelFactory {
    SudokuModel getModel(String filename) throws SudokuException;

    SudokuVue getVue(String filename) throws SudokuException;
}


