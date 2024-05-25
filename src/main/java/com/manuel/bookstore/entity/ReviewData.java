package com.manuel.bookstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@MappedSuperclass
@Table(name = "review")
public class ReviewData {

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

    public ReviewData(){}
    public ReviewData(int rating, String comment, LocalDate reviewDate, BookData book, StoreUserData customer) {
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.book = book;
        this.customer = customer;
    }
}
