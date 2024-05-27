package com.manuel.bookstore.api;

import com.manuel.bookstore.dto.request.BookRequest;
import com.manuel.bookstore.dto.response.BookResponse;
import com.manuel.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookResponse create(@RequestBody BookRequest request) {

        return BookResponse.fromDto(bookService.create(request));
    }

    @PutMapping("/edit/{id}")
    public BookResponse update(@RequestBody BookRequest request, @PathVariable UUID id){

       return BookResponse.fromDto(bookService.update(request, id));
    }
}
