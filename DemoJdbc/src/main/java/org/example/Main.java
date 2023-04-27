package org.example;

import org.example.models.entities.Book;
import org.example.models.forms.BookForm;
import org.example.services.BookServiceImpl;

public class Main {
    public static void main(String[] args) {

        BookServiceImpl bookService = new BookServiceImpl();

//        List<Book> books = bookService.getMany();
////        books.forEach(System.out :: println);

//        Book book = bookService.getOne(3);
//        System.out.println(book);

//        BookForm bookForm = new BookForm("Toto à la plage", "Il fait beau");
//        Book book = bookService.add(bookForm.toEntity());
//        System.out.println(book);

//        System.out.println(bookService.delete(4));
//        System.out.println(bookService.delete(5));

        System.out.println(bookService.update(1,new Book("Titre", "Descript")));

    }
}