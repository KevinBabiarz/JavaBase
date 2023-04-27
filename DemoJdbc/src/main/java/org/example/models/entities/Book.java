package org.example.models.entities;

import lombok.*;

// Constructeur du book en fonction de ce qui a ete mis ds la DB
@Builder @AllArgsConstructor @NoArgsConstructor @ToString @Getter @Setter @EqualsAndHashCode
public class Book {

    private Integer id;
    private String title;
    private String description;

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
