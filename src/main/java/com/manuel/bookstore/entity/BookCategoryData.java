package com.manuel.bookstore.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "book_category")
public class BookCategoryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<BookData> books;

    public BookCategoryData() {}

    public BookCategoryData(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
