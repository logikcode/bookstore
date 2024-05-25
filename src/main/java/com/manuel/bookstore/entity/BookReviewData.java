package com.manuel.bookstore.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book_review")
public class BookReviewData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating;
    private String comment;
    private LocalDate reviewDate;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookData book;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private StoreUserData customer;

    public BookReviewData(){}
    public BookReviewData(int rating, String comment, LocalDate reviewDate, BookData book, StoreUserData customer) {
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.book = book;
        this.customer = customer;
    }
}
