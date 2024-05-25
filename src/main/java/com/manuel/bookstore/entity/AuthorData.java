package com.manuel.bookstore.entity;

import com.manuel.bookstore.enumeration.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@MappedSuperclass
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
    @OneToMany(mappedBy = "author")
    private Set<BookData> books;

    public AuthorData() {}

    public AuthorData(String name, String biography, LocalDate birthdate, String nationality) {
        this.name = name;
        this.biography = biography;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }
}
