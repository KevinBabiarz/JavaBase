package be.technifutur.hello;

public class Hello{

    public static void main(String[] args){

        System.out.println("Ronaldo est nul");

        if(args.length > 0){
            System.out.println("Messi goat" + args[0]);
        }else{
            System.out.println("Messi goat");
        }


    }

}