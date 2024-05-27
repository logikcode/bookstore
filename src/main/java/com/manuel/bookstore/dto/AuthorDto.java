package com.manuel.bookstore.dto;

import com.manuel.bookstore.enumeration.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class AuthorDto {
    private UUID publicId;
    private String name;
    private String biography;
    private LocalDate birthdate;
    private String nationality;
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
