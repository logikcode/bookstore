package com.manuel.bookstore.dto;

import com.manuel.bookstore.entity.BaseEntity;
import com.manuel.bookstore.entity.BookData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class BookCategoryDto extends BaseEntity {

    private UUID publicId;
    private String name;
    private String description;

    public BookCategoryDto() {
    }

    public BookCategoryDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
