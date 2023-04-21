package org.example.data;

import org.example.models.Book;

import java.util.ArrayList;
import java.util.List;

public class FakeDb {

    public  static List<Book> books = new ArrayList<>();

    public static void init(){
        books.add(new Book(1,"toto1","super Livre1","jean mich1"));
        books.add(new Book(1,"toto2","super Livre2","jean mich2"));
        books.add(new Book(1,"toto3","super Livre3","jean mich3"));
        books.add(new Book(1,"toto4","super Livre4","jean mich4"));
        books.add(new Book(1,"toto5","super Livre5","jean mich5"));
        books.add(new Book(1,"toto6","super Livre6","jean mich6"));
    }

    public static Book getBook(Integer id){
       /* for (Book b : books){
            if(id == b.getId())
                return b;
        }
        return null;*/
        return books.stream()
                .filter(b -> b.getId() == id)
                .distinct()
                .findFirst()
                .orElse(null);
    }
}
