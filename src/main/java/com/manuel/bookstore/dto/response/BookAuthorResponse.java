package com.manuel.bookstore.dto.response;

import com.manuel.bookstore.dto.BookAuthorDto;
import com.manuel.bookstore.dto.BookCategoryDto;
import com.manuel.bookstore.entity.BaseEntity;
import com.manuel.bookstore.enumeration.Status;
import com.manuel.bookstore.utils.ObjectMapperUtils;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BookAuthorResponse extends BaseEntity {
    private UUID publicId;
    private String name;
    private String biography;
    private LocalDate birthdate;
    private String nationality;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    public BookAuthorResponse() {
    }

    public BookAuthorResponse(UUID publicId, String name, String biography, String nationality, Status status) {
        this.publicId = publicId;
        this.name = name;
        this.biography = biography;
        this.nationality = nationality;
        this.status = status;
    }

    public BookAuthorResponse(String name) {
        this.name = name;
        this.publicId = UUID.randomUUID();
        this.biography = "";
        this.status = Status.ACTIVE;
    }

    public static List<BookAuthorResponse> fromDto(List<BookAuthorDto> authorDtos) {
        return authorDtos.stream().map(c-> ObjectMapperUtils.map(c, BookAuthorResponse.class)).toList();
    }
}
