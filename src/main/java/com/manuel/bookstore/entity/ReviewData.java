package com.manuel.bookstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "reviews")
public class ReviewData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID publicId;
    private int rating;
    private String comment;
    private LocalDate reviewDate;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookData book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private StoreUserData user;

    public ReviewData(){}
    public ReviewData(int rating, String comment, BookData book, StoreUserData user) {
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = LocalDate.now();
        this.book = book;
        this.user = user;
    }
}
