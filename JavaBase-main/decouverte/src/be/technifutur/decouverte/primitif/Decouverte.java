package be.technifutur.decouverte.primitif;

public class Decouverte {
    
    public static void main(String[] args) {
        //boolean
        testboolean();
        //entier signé
        testByte();
        testShort();
        testInteger();
        testLong();
        // caractere
        testchar();
        // numerique flottant
        testfloat();
        testDouble();
    }

    private static void testDouble() {
        double test = 5.3;
        System.out.println( "division par 0" +(test / 0));
        System.out.println( "division par 0" +(0.0 / 0));

        test = Long.MAX_VALUE;
        for(int i =0; i < 200; i++){
            test-=100;
            long l = (long)test;
            System.out.printf(" double : %s %n",test,l);
        }
    }

    private static void testfloat() {
        float test = 5.3F;


    }

    private static void testchar() {
        char car = 'r';
        char car2 = 'a';
        int res  = car + car2;
        car = '\n'; //passer a la ligne



    }

    private static void testLong() {
        long test = Long.MAX_VALUE; // milliard de milliard
        test = 9_223_372_036_854_775_807L;
        int val = 5;
       // val = test - val; // long - int => long - long
        test = test - val;

    }

    private static void testInteger() {
        int test = Integer.MIN_VALUE; // -2.000.000.000 à 2.000.000.000
        int test2 =2; // 2 est un int

        test = test / test2; // DIV
        test = test % test2; // mod

        test = 0b00110; //6
        System.out.println("0b001100 = "+test);
        System.out.println("test & test2 = "+(test & test2)); //2
        System.out.println("test | test2 = "+(test | test2)); //7
        System.out.println("test ^ test2 = "+(test ^ test2)); //5
        System.out.println("~test +1 = "+(~test + 1));// -6

        System.out.println("test << 2 = "+(test << 2));
        System.out.println("test >> 2 = "+(test >> 2));
        System.out.println("test >> 2 = "+(test >>> 2));

        System.out.println(Integer.toBinaryString(test));


    }

    private static void testShort() {
        short test = Short.MIN_VALUE; // -30.000 à 30.000
        short test2 =2;
        int i = test2;
        //test = i;
        test = (short)i;
        test = (short)(test + test2);
        test += test2;
    }

    private static void testboolean() {
        boolean test = true, test2=false;
        test = false;
        // int i = test;
        // int i = (int)test;
        // test = 0;

        test = ! test;  //not
        test = test & test2; // et évaluation longue
        test = test && test2; // et évaluation courte
        test = test | test2; // et évaluation longue
        test = test || test2; // et évaluation courte
        test = test ^ test2; // xor

        test &= test2;
        test |= test2;
        test ^= test2;

        Boolean object = Boolean.TRUE;
        test = object; // auto unboxing
        test = object.booleanValue(); // unboxing
        object = test; // auto boxing
        object = Boolean.valueOf(test); //boxing

        if(test = false){
            System.out.println("false");
        }else{
            System.out.println("true");
        }
    }

    private static void testByte() {
        byte test = Byte.MIN_VALUE;
        byte test2 =2;
        int i = test2;
        //test = i;
        test = (byte)i;
        test = (byte)(test + test2);
        test += test2;

    }

}
