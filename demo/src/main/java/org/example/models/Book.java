package org.example.models;

import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Builder
public class Book {
/*
    public static int varStatic;
    public Integer a;
    protected Integer b;// accessible dans la classe et celle des ses enfants
    private Integer c; // accessible uniquemment dans la classe

    public void test(){
        this.b = 5;
        this.c = 10;
    }*/

    private static Integer currentid = 1;

    @Getter
    private Integer id;
    @Getter @Setter
    public String title;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private String author;

    public Book(){
        this.id = currentid++;
    }

    public Book(Integer id, String title, String description, String author) {

        this();
        this.title = title;
        this.description = description;
        this.author = author;
    }


    public void setDescription(String description) {
        if(description.trim().equals(""))
            throw new RuntimeException();

        this.description = description;
    }

    @Override
    public String toString(){
        return "Livre : \n" +
                "\t id = " + id + '\n' +
                "\t description + " + description + '\n' +
                "\t auteur + " + author + '\n'+
                "+---------------------------------+";
    }


}
