package be.technifutur.sudoku;

public interface SudokuModel {
    char EMPTY = 0;
    /**
     * Retourne le nombre de cellules valides du sudoku
     * @return le nombre de cellules
     */
    int cellCount();


    /**
     * Retourne la valeur du sudoku se trouvant à la position line, column.
      * @param line la ligne
     * @param column la colonne
     * @return la valeur
     */
    char getValue(int line, int column);

    /**
     * Modifie la valeur se trouvant à la position line, column.
     * @param line la ligne
     * @param column la colonne
     * @param value la valeur
     */
    void setValue(int line, int column, char value);

    /**
     * Retourne le nombre de lignes de la grille du sudoku.
     * @return le nombre de lignes
     */
    int getMaxLine();

    /**
     * Retourne le nombre de colonnes de la grille du sudoku.
     * @return le nombre de colonnes
     */
    int getMaxColumn();

    /**
     * Retourne true si la ligne et la colonne correspondent à une position d'une case du sudoku
     * @param line la ligne
     * @param column la colonne
     * @return true si la position est valide, sinon false
     */
    boolean isPositionValid(int line, int column);

    /**
     * Retourne true si la valeur correspond à  une position d'une case du sudoku
     * @param value la valeur
     * @return true si la valeur est valide, sinon false
     */
    boolean isValueValid(char value);

    boolean isEmpty(int l, int c);

}
