package com.manuel.bookstore.service;

import com.manuel.bookstore.dto.BookAuthorDto;
import com.manuel.bookstore.entity.AuthorData;
import com.manuel.bookstore.repository.AuthorsRepository;
import com.manuel.bookstore.utils.ObjectMapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorService {

    private final AuthorsRepository authorsRepository;

    public BookAuthorService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public List<BookAuthorDto> getBookAuthors(){

        return authorsRepository.findAll().stream().map(a-> ObjectMapperUtils.map(a, BookAuthorDto.class)).toList();
    }
}
