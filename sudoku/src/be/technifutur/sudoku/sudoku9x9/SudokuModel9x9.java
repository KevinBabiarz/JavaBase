package be.technifutur.sudoku.sudoku9x9;

import be.technifutur.sudoku.SudokuModel;

public class SudokuModel9x9 implements SudokuModel {

    private char[][] grille = new char[getMaxLine()][getMaxColumn()];
    static final char[] carPossible = {'1','2','3','4','5','6','7','8','9'};
    @Override
    public int cellCount() {

        int i = 81;
        return i;
    }

    @Override
    public char getValue(int line, int column) {

        return grille[line][column];
    }

    @Override
    public void setValue(int line, int column, char value) {

       grille[line][column]=value;
    }

    @Override
    public int getMaxLine() {
        return 9;
    }

    @Override
    public int getMaxColumn() {
        return 9;
    }

    @Override
    public boolean isPositionValid(int line, int column) {

        boolean result = false;
        if((line < getMaxLine() && line >= 0) && (column < getMaxColumn() && column >= 0)){
            result = true;
        }

        return result;
    }

    @Override
    public boolean isValueValid(char value) {
        boolean result = false;
        for (int i = 0; i < carPossible.length; i++) {
            if(carPossible[i] == value){
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean isEmpty(int l, int c) {

        boolean result = false;
        if(grille[l][c] == EMPTY){
            result = true;
        }

        return result;
    }
}
