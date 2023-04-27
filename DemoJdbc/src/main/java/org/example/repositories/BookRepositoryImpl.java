package org.example.repositories;

import org.example.exeption.BookException;
import org.example.exeption.BookNotFoundException;
import org.example.models.entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Sert à communiquer avec la DB, envoyer les requetes,...
public class BookRepositoryImpl implements BookRepository{

    private Book buildBook(ResultSet rs){
        try {
            return Book.builder()
                    .id(rs.getInt("BOOK_ID"))
                    .title(rs.getString("TITLE"))
                    .description(rs.getString("DESCRIPTION"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Book getOne(Integer id) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo.jdbc","postgres","postgres");
            PreparedStatement psmt = conn.prepareStatement("SELECT * FROM BOOK WHERE BOOK_ID = ?");

            psmt.setInt(1,id);

            ResultSet rs = psmt.executeQuery();

            if (!rs.next()){
                throw new BookNotFoundException();
            }
            conn.close();
            return buildBook(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getMany() {

        try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo.jdbc","postgres","postgres");) {

            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM BOOK");

            List<Book> books = new ArrayList<>();

            while(rs.next()){
//                Book book =Book.builder()
//                        .id(rs.getInt("BOOK_ID"))
//                        .title(rs.getString("TITLE"))
//                        .description(rs.getString("DESCRIPTION"))
//                        .build();
//                Integer id = rs.getInt("BOOK_ID");
//                String title = rs.getString("TITLE");
//                String description = rs.getString("DESCRIPTION");
//                Book book = new Book(id,title,description);

//                Book book = new Book(rs.getInt("BOOK_ID"), rs.getNString("TITLE"),rs.getString("DESCRIPTION"));

//                books.add(book);
//                System.out.println(book);
                books.add(buildBook(rs));
            }
            conn.close();
            return books;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Book add(Book book) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo.jdbc","postgres","postgres");
            PreparedStatement psmt = conn.prepareStatement("INSERT INTO BOOK (TITLE,DESCRIPTION) VALUES(?,?) RETURNING *");
            psmt.setString(1,book.getTitle());
            psmt.setString(2, book.getDescription());
            ResultSet rs = psmt.executeQuery();
            if(!rs.next())
                throw new BookException("Failed");

            conn.close();
            return buildBook(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Integer id, Book book) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo.jdbc", "postgres", "postgres");
            PreparedStatement psmt = conn.prepareStatement("UPDATE BOOK SET TITLE = ?,DESCRIPTION = ? WHERE BOOK_ID = ?");
            psmt.setString(1,book.getTitle());
            psmt.setString(2, book.getDescription());
            psmt.setInt(3, id);


            int nbRow = psmt.executeUpdate();
            conn.close();
            return nbRow == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo.jdbc", "postgres", "postgres");
            PreparedStatement psmt = conn.prepareStatement("DELETE FROM BOOK WHERE BOOK_ID = ?");
            psmt.setInt(1, id);


            int nbRow = psmt.executeUpdate();
            conn.close();
            return nbRow == 1;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
