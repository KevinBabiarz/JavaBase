package be.technifutur.sudoku;

import javax.print.DocFlavor;

public abstract class AbstractSudokuVue {

    private String format;
    private SudokuModel model;

    public AbstractSudokuVue(String format, SudokuModel model) {
        this.format = format;
        this.model = model;
    }

    public String getScreen() {
        Character[] val = new Character[model.cellCount()];
        int pos = 0;
        for (int l = 0; l < model.getMaxLine(); l++) {
            for (int c = 0; c < getModel().getMaxColumn(); c++) {
                if (model.isPositionValid(l, c)) {
                    if (model.isEmpty(l, c)) {
                        val[pos] = '.';
                    } else {
                        val[pos] = model.getValue(l, c);
                    }
                    pos++;
                }
            }
        }
        return String.format(format, val);
    }

    public SudokuModel getModel() {
        return this.model;
    }

}
