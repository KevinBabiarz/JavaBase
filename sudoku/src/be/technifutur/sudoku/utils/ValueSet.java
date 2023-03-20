package be.technifutur.sudoku.utils;

public class ValueSet {

    private String name;

    public String getName(){
        return name;
    }

    public ValueSet(String name){
        this.name = name;
    }

    private int data = 0;

    public boolean containts(char value){
        int mask = getMask(value);
        boolean result = (data & mask) != 0;
        return result;
    }

    private static int getMask(char value) {
        int val = Character.digit(value,10);
        int mask = 1 << val;
        return mask;
    }

    public boolean add(char value){
        int mask = getMask(value);
        int anc = data;
        data = data | mask;
        return anc != data;
    }

    public boolean remove(char value){
        int val = Character.digit(value,10);
        int mask = ~getMask(value);
        int anc = data;
        data = data & mask;
        return anc != data;
    }

    public static void main(String[] args) {
        ValueSet valueSet = new ValueSet("name");

        System.out.println(valueSet.containts('2')== false);
        System.out.println(valueSet.containts('0')== false);
        System.out.println(valueSet.containts('9')== false);
        System.out.println(valueSet.containts('1')== false);
        valueSet.add('1');


    }
}
