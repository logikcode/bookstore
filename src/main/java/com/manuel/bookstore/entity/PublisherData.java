package com.manuel.bookstore.entity;

import com.manuel.bookstore.enumeration.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@MappedSuperclass
@Table(name = "publishers")
public class PublisherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID publicId;
    private String name;
    private String address;
    private String contactInfo;
    @Enumerated(value = EnumType.STRING)
    private Status publisherStatus;
    @OneToMany(mappedBy = "publisher")
    private Set<BookData> books;

    public PublisherData() {}

    public PublisherData(String name, String address, String contactInfo) {
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
    }
}
