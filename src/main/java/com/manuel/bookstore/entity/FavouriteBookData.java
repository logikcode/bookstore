package com.manuel.bookstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user_favourite_books")
public class FavouriteBookData extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID publicId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private StoreUserData user;

    @ManyToMany
    @JoinTable(
            name = "favourite_books",
            joinColumns = @JoinColumn(name = "favourite_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<BookData> books;

    public FavouriteBookData() {
    }

    public FavouriteBookData(StoreUserData user) {
        this.user = user;
    }
}
