package com.manuel.bookstore.dto.response;

import com.manuel.bookstore.dto.BookDto;
import com.manuel.bookstore.entity.AuthorData;
import com.manuel.bookstore.enumeration.BookStatus;
import com.manuel.bookstore.utils.ObjectMapperUtils;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Data
public class BookResponse {

    private String title;
    private UUID publicId;
    private String isbn;
    private BigDecimal price;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private BookStatus availabilityStatus;

    private Set<String> authors;

    private String publisherName;

    private String categoryName;

    public static BookResponse fromDto(BookDto dto){
        return ObjectMapperUtils.map(dto, BookResponse.class);
    }
}
