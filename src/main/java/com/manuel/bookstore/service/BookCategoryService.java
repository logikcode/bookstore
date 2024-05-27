package com.manuel.bookstore.service;

import com.manuel.bookstore.dto.BookCategoryDto;
import com.manuel.bookstore.repository.BookCategoryRepository;
import com.manuel.bookstore.utils.ObjectMapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryService {

    private final BookCategoryRepository categoryRepository;

    public BookCategoryService(BookCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<BookCategoryDto> getCategories(){

       return categoryRepository.findAll().stream()
               .map(c-> ObjectMapperUtils.map(c, BookCategoryDto.class)).toList();
    }
}
