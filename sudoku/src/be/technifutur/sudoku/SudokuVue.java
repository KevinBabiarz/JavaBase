package be.technifutur.sudoku;

public interface SudokuVue {
    String getScreen() throws SudokuPositionException;
    SudokuModel getModel();
}
