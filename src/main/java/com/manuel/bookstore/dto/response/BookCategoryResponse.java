package com.manuel.bookstore.dto.response;

import com.manuel.bookstore.dto.BookCategoryDto;
import com.manuel.bookstore.entity.BaseEntity;
import com.manuel.bookstore.utils.ObjectMapperUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class BookCategoryResponse extends BaseEntity {

    private UUID publicId;
    private String name;
    private String description;


    public BookCategoryResponse() {
    }

    public BookCategoryResponse(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static List<BookCategoryResponse> fromDto(List<BookCategoryDto> categories) {
        return categories.stream().map(c-> ObjectMapperUtils.map(c, BookCategoryResponse.class)).toList();
    }
}
