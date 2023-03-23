package be.technifutur.sudoku;

public abstract class AbstractSudokuModel{

    private Cell[][] grille = new Cell[getMaxLine()][getMaxColumn()];


    public AbstractSudokuModel(){
        initGameBoard();
    }

    protected Cell getCellule(int line, int column){
        return grille[line][column];
    }

    public abstract int cellCount();

    char EMPTY = 0;

    public char getValue(int line, int column) throws SudokuPositionException {
        if (isPositionValid(line, column)) {
            return this.grille[line][column].getValue();
        } else {
            throw new SudokuPositionException("Position incorrect " + (line + column));
        }
    }


    public void setValue(int line, int column, char value) throws SudokuException, DoublonException {
        if (isPositionValid(line,column)) {
            if (isValueValid(value)) {
                this.grille[line][column].setValue(value);
            }
            else {
                if (value == SudokuModel.EMPTY) {
                    this.grille[line][column].setValue(SudokuModel.EMPTY);
                }
                else {
                    throw new SudokuValueException("Valeur incorrect " + value);
                }
            }
        } else {
            throw new SudokuPositionException("Position incorrect "+(line+1)+" "+(column+1));
        }
    }


    public abstract int getMaxLine();



    public abstract int getMaxColumn();


    public abstract boolean isPositionValid(int line, int column);


    public abstract boolean isValueValid(char value);


    public boolean isEmpty(int l, int c) {

        boolean result = false;

        if(grille[l][c].getValue()==EMPTY){
            result = true;
        }
        return result;
    }

    public void lock(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grille[i][j].lock();
            }
        }


    }
    public void clearCell(int lineNumber, int columnNumber) throws SudokuLockException, DoublonException, SudokuException {
        this.grille[lineNumber][columnNumber].setValue(SudokuModel.EMPTY);
    }

    protected Cell getCell(int line, int column){
        return this.grille[line][column];
    }

    public void initGameBoard() {
        for (int i = 0; i < this.grille.length; i++) {
            for (int j = 0; j < this.grille[i].length; j++) {
                this.grille[i][j] = new Cell();
            }
        }
    }
}
