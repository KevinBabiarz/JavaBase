package be.technifutur.sudoku;

public class SudokuException extends Exception{
    public SudokuException() {
    }

    public SudokuException(String message) {
        super(message);
    }

    public SudokuException(String message, Throwable cause) {
        super(message, cause);
    }

    public SudokuException(Throwable cause) {
        super(cause);
    }
}
