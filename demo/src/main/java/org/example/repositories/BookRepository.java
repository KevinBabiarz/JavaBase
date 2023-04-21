package org.example.repositories;

import org.example.data.FakeDb;
import org.example.models.Book;
import org.example.models.forms.AddBookForm;

import java.util.List;
import java.util.Optional;

public class BookRepository {

    public List<Book> getMany(){
        return FakeDb.books;
    }
    //TODO Ajouter getMany avec interfaceFonctionnelle

    public Optional<Book> getOne(Integer id){
        return FakeDb.books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    public void add(Book b){

        FakeDb.books.add(b);
    }

    public boolean update(Integer id, AddBookForm form){

        Book oldBook = getOne(id).orElse(null);

        if (oldBook == null) {
            return false;
        }

        oldBook.setTitle(form.getTitle());
        oldBook.setDescription(form.getDescription());
        oldBook.setAuthor(form.getAuthor());

        return true;
    }

    public boolean delete(Integer id){

        Book oldBook = getOne(id).orElse(null);

        if(oldBook == null){
            return false;
        }

        FakeDb.books.remove(oldBook);

        return true;
    }
}
