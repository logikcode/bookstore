package com.manuel.bookstore.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "book_author")
public class BookAuthorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String biography;
    private LocalDate birthdate;
    private String nationality;

    @OneToMany(mappedBy = "author")
    private Set<BookAuthorData> books;

    public BookAuthorData() {}

    public BookAuthorData(String name, String biography, LocalDate birthdate, String nationality) {
        this.name = name;
        this.biography = biography;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }
}
