package com.manuel.bookstore.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class BookData {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private BigDecimal price;
    private LocalDate publicationDate;
    private String description;
    private String availabilityStatus;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private BookAuthorData author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private BookPublisherData publisher;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private BookCategoryData category;

    public BookData() {}

    public BookData(String title, String isbn, BigDecimal price, LocalDate publicationDate, String description, String availabilityStatus, BookAuthorData author, BookPublisherData publisher, BookCategoryData category) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.publicationDate = publicationDate;
        this.description = description;
        this.availabilityStatus = availabilityStatus;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }
}
