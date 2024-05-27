package com.manuel.bookstore.dto;

import com.manuel.bookstore.entity.BaseEntity;
import com.manuel.bookstore.enumeration.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class BookAuthorDto extends BaseEntity {
    private UUID publicId;
    private String name;
    private String biography;
    private LocalDate birthdate;
    private String nationality;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    public BookAuthorDto() {
    }

    public BookAuthorDto(UUID publicId, String name, String biography, String nationality, Status status) {
        this.publicId = publicId;
        this.name = name;
        this.biography = biography;
        this.nationality = nationality;
        this.status = status;
    }

    public BookAuthorDto(String name) {
        this.name = name;
        this.publicId = UUID.randomUUID();
        this.biography = "";
        this.status = Status.ACTIVE;
    }
}
