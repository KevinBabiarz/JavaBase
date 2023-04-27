package org.example.models;

import java.util.Date;

public class Fish extends Animals{
    public Fish(String name, Date birthdate) {
        super(name, birthdate);
    }

    @Override
    public void move() {
        System.out.println("I'm a fish and I swim fast");
    }

    public void gloops(){
        System.out.println("Gloups");
    }
}
