package be.technifutur.sudoku;

public class SudokuLockException extends SudokuException{
    public SudokuLockException() {
    }

    public SudokuLockException(String message) {
        super(message);
    }

    public SudokuLockException(String message, Throwable cause) {
        super(message, cause);
    }

    public SudokuLockException(Throwable cause) {
        super(cause);
    }
}
