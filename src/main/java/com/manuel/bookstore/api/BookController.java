package com.manuel.bookstore.api;

import com.manuel.bookstore.dto.BookDto;
import com.manuel.bookstore.dto.request.BookRequest;
import com.manuel.bookstore.dto.response.BookResponse;
import com.manuel.bookstore.enumeration.BookStatus;
import com.manuel.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public BookResponse update(@RequestBody BookRequest request, @PathVariable UUID id) {

        return BookResponse.fromDto(bookService.update(request, id));
    }

    @GetMapping
    public Page<BookDto> getAllBooks(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortField", defaultValue = "title") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection) {
        return bookService.getBooks(page, size, sortField, sortDirection);
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable UUID id) {
        return BookResponse.fromDto(bookService.getBooK(id));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable UUID id) {
        bookService.delete(id);
    }

    @PutMapping("/{id}/status")
    public BookResponse updateBookStatus(@PathVariable UUID id, @RequestParam("status") BookStatus status) {
        return BookResponse.fromDto(bookService.updateBookStatus(id, status));
    }
}
