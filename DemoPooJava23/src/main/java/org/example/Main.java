package org.example;

import org.example.models.Animals;
import org.example.models.Bird;
import org.example.models.Dog;
import org.example.models.Fish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Animals> animal = new ArrayList<>();
        animal.add(new Dog("Doggo", new Date(2005,03,20)));
        animal.add(new Fish("Fishy", new Date(2010,05,8)));
        animal.add(new Bird("Birdo", new Date(2013,07,15)));

        for (Animals a : animal){

            a.move();

            if(a instanceof Dog d)
                d.bark();
            if(a instanceof Fish f)
                f.gloops();
            if(a instanceof Bird b)
                b.shit();
        }
    }
}