package com.manuel.bookstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@MappedSuperclass
@Table(name = "publishers")
public class PublisherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String contactInfo;

    @OneToMany(mappedBy = "publisher")
    private Set<BookData> books;

    public PublisherData() {}

    public PublisherData(String name, String address, String contactInfo) {
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
    }
}
