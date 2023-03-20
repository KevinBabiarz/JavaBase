package be.technifutur.sudoku;

import be.technifutur.sudoku.utils.ValueSet;

import java.util.ArrayList;

public class Cell {

    private char value = SudokuModel.EMPTY;
    private boolean lock = false;
    private ArrayList<ValueSet> valueSetList = new ArrayList<>();

    public boolean add(ValueSet zone){
        return valueSetList.add(zone);
    }

    public static void main(String[] args) {
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

     public char getValue(){
         return value;
     }

     public void setValue(char value){
        if(lock == false ){
            this.value=value;
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
