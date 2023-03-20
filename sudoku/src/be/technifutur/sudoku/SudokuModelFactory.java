package be.technifutur.sudoku;

public interface SudokuModelFactory {
    SudokuModel getModel(String filename);

    SudokuVue getVue(String filename);
}


