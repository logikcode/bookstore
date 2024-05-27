package com.manuel.bookstore.api;

import com.manuel.bookstore.dto.response.BookAuthorResponse;
import com.manuel.bookstore.dto.response.BookCategoryResponse;
import com.manuel.bookstore.service.BookAuthorService;
import com.manuel.bookstore.service.BookCategoryService;
import jakarta.persistence.Basic;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authors")
public class BookAuthorController {

    private final BookAuthorService bookAuthorService;

    @GetMapping
    public List<BookAuthorResponse> getBookAuthors() {
        return BookAuthorResponse.fromDto(bookAuthorService.getBookAuthors());
    }
}
