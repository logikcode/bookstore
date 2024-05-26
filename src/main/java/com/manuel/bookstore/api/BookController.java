package com.manuel.bookstore.api;

import com.manuel.bookstore.dto.request.BookRequest;
import com.manuel.bookstore.dto.response.BookResponse;
import com.manuel.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookResponse create(@RequestBody BookRequest request) {

        return BookResponse.fromDto(bookService.create(request));
    }
}
