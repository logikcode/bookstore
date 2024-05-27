package com.manuel.bookstore.api;

import com.manuel.bookstore.dto.response.BookCategoryResponse;
import com.manuel.bookstore.service.BookCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class BookCategoryController {

    private final BookCategoryService bookCategoryService;

    @GetMapping
    public List<BookCategoryResponse> getCategories() {
        return BookCategoryResponse.fromDto(bookCategoryService.getCategories());
    }
}
