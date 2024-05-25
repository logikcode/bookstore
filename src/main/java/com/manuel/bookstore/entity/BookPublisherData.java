package com.manuel.bookstore.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "book_publisher")
public class BookPublisherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String contactInfo;

    @OneToMany(mappedBy = "publisher")
    private Set<BookData> books;

    public BookPublisherData() {}

    public BookPublisherData(String name, String address, String contactInfo) {
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
    }
}
