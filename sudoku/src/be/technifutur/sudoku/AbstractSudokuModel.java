package be.technifutur.sudoku;

public abstract class AbstractSudokuModel{

    private Cell[][] grille = new Cell[getMaxLine()][getMaxColumn()];


    public AbstractSudokuModel(){
        for (int i = 0; i < getMaxLine(); i++) {
            for (int j = 0; j < getMaxColumn(); j++) {
                if(isPositionValid(i,j)){
                    grille[i][j] = new Cell();
                }
            }
        }
    }

    protected Cell getCellule(int line, int column){
        return grille[line][column];
    }

    public abstract int cellCount();

    char EMPTY = 0;

    public char getValue(int line, int column) {

        return grille[line][column].getValue();
    }


    public void setValue(int line, int column, char value) {

        grille[line][column].setValue(value);
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

}
