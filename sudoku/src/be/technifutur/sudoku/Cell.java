package be.technifutur.sudoku;

import be.technifutur.sudoku.utils.ValueSet;

import java.util.ArrayList;

/* Sert a créer une cellule */
public class Cell {

    private char value = SudokuModel.EMPTY;
    private char newValue;
    private boolean lock = false;
    private ArrayList<ValueSet> valueSetList = new ArrayList<>();

    /*
    public static void main(String[] args) throws SudokuLockException {
        Cell cellule = new Cell();
        ValueSet ligne = new ValueSet("ligne 1");
        cellule.add(ligne);
        ValueSet colonne = new ValueSet("colonne 5");
        cellule.add(colonne);
        cellule.add(new ValueSet("carre 2"));

        System.out.println(cellule.valueSetList.size());
        System.out.println(cellule.valueSetList.get(1).getName());
        System.out.println(cellule.valueSetList.get(1).containts('3'));
    }
    */

    protected ArrayList<ValueSet> getValueSetList(){
        return valueSetList;
    }

    public Cell(){
        this.value = SudokuModel.EMPTY;
        this.lock = false;
    }

    public boolean add(ValueSet zone){
        return valueSetList.add(zone);
    }
     public char getValue(){
         return value;
     }

    public void setValue(char value) throws DoublonException, SudokuException {
        if (this.value != value) {
            if (this.isLock()) {
                throw new SudokuLockException("Imposssible de modifier une valeur lock");
            }
            if (value != SudokuModel.EMPTY) {
                for (ValueSet set : valueSetList) {
                    if (set.containts(value)) {
                        throw new DoublonException("Contient deja la valeur: " + value + " dans " + set.getName());
                    }
                }
            }
            if (this.value != SudokuModel.EMPTY) {
                for (ValueSet v : this.valueSetList) {
                    v.remove(this.value);
                }
            }

            if (value != SudokuModel.EMPTY) {
                for (ValueSet v : this.valueSetList) {
                    v.add(value);
                }
            }

            this.value = value;
        }
    }


     public void lock(){
         if(value != SudokuModel.EMPTY){
             lock = true;
         }
     }

     public boolean isLock(){
         return lock;
     }


}
