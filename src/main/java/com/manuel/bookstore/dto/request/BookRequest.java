package com.manuel.bookstore.dto.request;

import com.manuel.bookstore.entity.AuthorData;
import com.manuel.bookstore.entity.CategoryData;
import com.manuel.bookstore.entity.PublisherData;
import com.manuel.bookstore.enumeration.BookStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookRequest {

    private String title;

    private BigDecimal price;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private BookStatus availabilityStatus;

    private String authorName;

    private String publisherName;

    private String categoryName;
}
