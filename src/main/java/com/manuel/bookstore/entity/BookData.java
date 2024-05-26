package com.manuel.bookstore.entity;

import com.manuel.bookstore.enumeration.BookStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "books", indexes = {
        @Index(name = "idx_book_title", columnList = "title"),
        @Index(name = "idx_book_isbn", columnList = "isbn"),
        @Index(name = "idx_book_author_id", columnList = "author_id"),
        @Index(name = "idx_book_publisher_id", columnList = "publisher_id"),
        @Index(name = "idx_book_category_id", columnList = "category_id")
})
public class BookData extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID publicId;

    private String title;

    private String isbn;

    private BigDecimal price;

    private LocalDate publicationDate;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private BookStatus availabilityStatus;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<AuthorData> authors = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherData publisher;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryData category;

    public BookData() {
    }

    public BookData(UUID publicId, String title, String isbn, BigDecimal price, LocalDate publicationDate,
                    String description, BookStatus availabilityStatus, AuthorData author, PublisherData publisher,
                    CategoryData category) {
        this.publicId = publicId;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.publicationDate = publicationDate;
        this.description = description;
        this.availabilityStatus = availabilityStatus;
        this.publisher = publisher;
        this.category = category;

        setBookAuthor(author);
    }

    public void setBookAuthor(AuthorData author) {
        this.authors.add(author);
    }
}
