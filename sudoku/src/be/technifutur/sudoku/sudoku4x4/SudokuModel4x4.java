package be.technifutur.sudoku.sudoku4x4;

import be.technifutur.sudoku.Cell;
import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.AbstractSudokuModel;
import be.technifutur.sudoku.utils.ValueSet;

public class SudokuModel4x4 extends AbstractSudokuModel implements SudokuModel {

    private Cell[][] grille = new Cell[getMaxLine()][getMaxColumn()];

    public SudokuModel4x4(){

        ValueSet[] columnZone = new ValueSet[4];
        ValueSet[] squareZone = new ValueSet[4];
        for (int i = 0; i < 4; i++) {
            columnZone[i]=new ValueSet("colonne"+ (i+1));
            squareZone[i]=new ValueSet("carre"+ (i+1));
        }
        ValueSet lineZone;
        for (int i = 0; i < 4; i++) {
            lineZone = new ValueSet("ligne"+(i+1));
            for (int j = 0; j < 4; j++) {
                Cell cellule = getCellule(i, j);
                cellule.add(lineZone);
                cellule.add(columnZone[j]);
                cellule.add(squareZone[i/2*2+j/2]);
                System.out.printf("ligne %s colonne %s : %s,%s, %s%n",i,j,lineZone.getName(),columnZone[j].getName(),squareZone[i/2*2+j/2].getName());
            }
        }
    }

    @Override
    public int cellCount() {

        return 16;
    }


    @Override
    public int getMaxLine() {

        return 4;
    }

    @Override
    public int getMaxColumn() {

        return 4;
    }

    @Override
    public boolean isPositionValid(int line, int column) {

        boolean result = false;
        if((line <= getMaxLine() || line >= 0) && (column <= getMaxColumn() || column >= 0)){
            result = true;
        }

        return result;
    }

    @Override
    public boolean isValueValid(char value) {

        final char[] carPossible = {'1','2','3','4'};
        boolean result = false;
        for (int i = 0; i < carPossible.length; i++) {
            if(carPossible[i] == value){
                result = true;
            }
        }
        return result;
    }


}
