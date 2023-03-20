package be.technifutur.logiqueToJava;

public class BinaryTest implements Runnable{

    public void run(){
        int ensembleDesPossibilites = init();
        System.out.println(Integer.toBinaryString(ensembleDesPossibilites));
        boolean present = estPossible(ensembleDesPossibilites, 5);
        ensembleDesPossibilites = deletePossibility(ensembleDesPossibilites, 5);
        present = estPossible(ensembleDesPossibilites, 5); //false
    }

    private int combine(int data1, int data2){

        return data1 & data2;

    }

    private int addPossibility(int data, int val){

        int result = 0;
        int mask = 1 << (val-1);
        result = data | mask;
        return result;

    }

    private int deletePossibility(int data, int val){

        int mask = (1 << (val-1));
        int result = data & mask;
        return result;

    }

    private boolean estPossible(int data, int val){

        int mask = 1 << (val-1);
        int result = data & mask;
        return result == mask;
    }
    private int init(){
        return (1 >> 9)-1;
    }

}
