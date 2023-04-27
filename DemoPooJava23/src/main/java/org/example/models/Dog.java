package org.example.models;

import java.util.Date;

public class Dog extends Animals{
    public Dog(String name, Date birthdate) {
        super(name, birthdate);
    }

    @Override
    public void move() {
        System.out.println("I'm a dog and I run");
    }

    public void bark(){
        System.out.println("Wouf");
    }
}
