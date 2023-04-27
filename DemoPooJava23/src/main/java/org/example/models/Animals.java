package org.example.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.util.Date;


public abstract class Animals {

    private String name;
    private Date birthdate;

    public Animals(String name, Date birthdate) {

        this.name = name;
        this.birthdate = birthdate;
    }

    public abstract void move();
}
