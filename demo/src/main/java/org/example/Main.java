package org.example;

import org.example.models.Book;
import org.example.data.FakeDb;
import org.example.models.forms.AddBookForm;
import org.example.repositories.BookRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

     FakeDb.init();
     BookRepository bookRepository = new BookRepository();
//       /* for (Book b: FakeDb.books){
//            System.out.println(b);
//        }
//        FakeDb.books.forEach(b -> System.out.println(b));
//        FakeDb.books.forEach(System.out::println);*/
//
//        Map<Integer,Book> books = new HashMap<>();
//
//        for (Book b: FakeDb.books){
//            books.put(b.getId(),b);
//        }
//
//        for (Book b : books.values()){
//
//        }
//
//        System.out.println(FakeDb.getBook(5));
//
//        UUID id = UUID.randomUUID();
//        System.out.println(id);

//        int a = 2;
//        changeValue(a);
//        System.out.println(a);
//
//        Book b = new Book(1,"tata","","");
//        changeValue(b);
//        System.out.println(b.getTitle());
    List<Book> books = bookRepository.getMany();

        Book newBook = new Book(1,"testAdd","","");
        bookRepository.add(newBook);

        books = bookRepository.getMany();
        AddBookForm form = new AddBookForm("toto","","");

        bookRepository.update(7,form);

        bookRepository.delete(7);

        showList(books);
    }

    public static void showList(List<Book> books){

        books.forEach(System.out::println);
    }


}