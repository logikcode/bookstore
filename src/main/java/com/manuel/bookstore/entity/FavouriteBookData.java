package com.manuel.bookstore.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@MappedSuperclass
@Table(name = "favourite_book")
public class FavouriteBookData extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private StoreUserData user;

    @ManyToMany
    @JoinTable(
            name = "order_books",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<BookData> books;

    public FavouriteBookData() {
    }

    public FavouriteBookData(StoreUserData user) {
        this.user = user;
    }
}
