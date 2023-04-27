package org.example.services;

import org.example.exeption.BookNotFoundException;
import org.example.models.entities.Book;
import org.example.repositories.BookRepository;
import org.example.repositories.BookRepositoryImpl;

import java.util.List;

public class BookServiceImpl {

    private BookRepository bookRepository;
    public BookServiceImpl(){

        this.bookRepository = new BookRepositoryImpl();
    }

    public Book getOne(Integer id){

        return bookRepository.getOne(id);
    }

    public List<Book> getMany(){
        return bookRepository.getMany();
    }

    public Book add(Book book){
        return bookRepository.add(book);
    }

    public boolean delete(Integer id){

        if (!bookRepository.delete(id))
            throw new BookNotFoundException();

        return true;
    }

    public boolean update(Integer id, Book book){

        if (!bookRepository.update(id, book))
            throw new BookNotFoundException();

        return true;
    }
}
