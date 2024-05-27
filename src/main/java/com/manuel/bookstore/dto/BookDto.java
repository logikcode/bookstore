package com.manuel.bookstore.dto;

import com.manuel.bookstore.entity.AuthorData;
import com.manuel.bookstore.enumeration.BookStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Data
public class BookDto {

    private String title;
    private UUID publicId;
    private String isbn;
    private BigDecimal price;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private BookStatus availabilityStatus;

    private Set<AuthorDto> authors;

    private String publisherName;

    private String categoryName;

}
