package org.example.exeption;

public class BookNotFoundException extends BookException{
    public BookNotFoundException(String message) {
        super(message);
    }
    public BookNotFoundException() {
        super("BookNotFound");
    }
}
