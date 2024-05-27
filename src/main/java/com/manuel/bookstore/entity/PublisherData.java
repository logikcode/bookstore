package com.manuel.bookstore.entity;

import com.manuel.bookstore.enumeration.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "publishers")
public class PublisherData extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID publicId;
    private String name;
    private String address;
    private String contactNumber;
    @Enumerated(value = EnumType.STRING)
    private Status publisherStatus;
    @OneToMany(mappedBy = "publisher")
    private Set<BookData> books =new HashSet<>();

    public PublisherData() {}

    public PublisherData(UUID publicId, String name, String address, String contactNumber, Status publisherStatus) {
        this.publicId = publicId;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.publisherStatus = publisherStatus;
    }

    public PublisherData(String name, String address, String contactNumber) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }
    public void setBooks(BookData book){
        this.books.add(book);
    }

    public PublisherData(String name) {
        this.publicId = UUID.randomUUID();
        this.name = name;
        this.publisherStatus = Status.ACTIVE;
    }
}

