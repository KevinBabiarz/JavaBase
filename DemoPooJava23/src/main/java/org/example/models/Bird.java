package org.example.models;

import java.util.Date;

public class Bird extends Animals{
    public Bird(String name, Date birthdate) {
        super(name, birthdate);
    }

    @Override
    public void move() {
        System.out.println("I'm a bird and I fly really high");
    }

    public void shit(){
        System.out.println("Take that !");
    }
}
