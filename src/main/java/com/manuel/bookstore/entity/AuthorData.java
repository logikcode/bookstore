package com.manuel.bookstore.entity;

import com.manuel.bookstore.enumeration.Status;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "authors", indexes = {
        @Index(name = "idx_author_name", columnList = "name")
})
public class AuthorData extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID publicId;
    private String name;
    private String biography;
    private LocalDate birthdate;
    private String nationality;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToMany(mappedBy = "authors")
    private Set<BookData> books = new HashSet<>();

    public AuthorData() {}

    public AuthorData(UUID publicId, String name, String biography, LocalDate birthdate, String nationality, Status status) {
        this.publicId= publicId;
        this.name = name;
        this.biography = biography;
        this.birthdate = birthdate;
        this.nationality = nationality;
        this.status = status;
    }
}
