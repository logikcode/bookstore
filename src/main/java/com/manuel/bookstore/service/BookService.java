package com.manuel.bookstore.service;

import com.manuel.bookstore.dto.BookDto;
import com.manuel.bookstore.dto.request.BookRequest;
import com.manuel.bookstore.entity.AuthorData;
import com.manuel.bookstore.entity.BookData;
import com.manuel.bookstore.entity.PublisherData;
import com.manuel.bookstore.enumeration.Status;
import com.manuel.bookstore.exceptions.DuplicateEntryExceptionBookStore;
import com.manuel.bookstore.exceptions.NotFoundExceptionBookStore;
import com.manuel.bookstore.repository.AuthorsRepository;
import com.manuel.bookstore.repository.BookCategoryRepository;
import com.manuel.bookstore.repository.BookPublisherRepository;
import com.manuel.bookstore.repository.BookRepository;
import com.manuel.bookstore.utils.ObjectMapperUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class BookService {

    private final ISBNService isbnService;
    private final AuthorsRepository authorsRepository;
    private final BookCategoryRepository categoryRepository;
    private final BookPublisherRepository publisherRepository;
    private final BookRepository bookRepository;

    public BookService(ISBNService isbnService, AuthorsRepository authorsRepository, BookCategoryRepository categoryRepository, BookPublisherRepository publisherRepository, BookRepository bookRepository) {
        this.isbnService = isbnService;
        this.authorsRepository = authorsRepository;
        this.categoryRepository = categoryRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    public BookDto create(BookRequest request) {

        bookRepository.findBookDataByTitle(request.getTitle())
                .ifPresent(bookData -> {
                    throw new DuplicateEntryExceptionBookStore("Book with name already exist", false);
                });

        var bookDto = ObjectMapperUtils.map(request, BookDto.class);
        var categoryData = categoryRepository.findCategoryDataByName(bookDto.getCategoryName())
                .orElseThrow(() -> new NotFoundExceptionBookStore("Please provide valid book category name", false));

        var authorData = authorsRepository.findAuthorDataByName(request.getAuthorName())
                .orElseGet(() -> authorsRepository.save(new AuthorData(UUID.randomUUID(), request.getAuthorName(), "", LocalDate.now(), "", Status.ACTIVE)));

        var publisherData = publisherRepository.findPublisherDataByName(request.getPublisherName())
                .orElseGet(() -> publisherRepository.save(new PublisherData(UUID.randomUUID(), request.getPublisherName(), "", "", Status.ACTIVE)));

        var bookData = new BookData(UUID.randomUUID(), request.getTitle(), isbnService.generateISBN(), request.getPrice(), LocalDate.now(),
                request.getDescription(), request.getAvailabilityStatus(), authorData, publisherData, categoryData);

         bookData = bookRepository.save(bookData);
        categoryData.setBookCategory(bookData);
        publisherData.setBooks(bookData);

        categoryRepository.save(categoryData);
        publisherRepository.save(publisherData);

        return ObjectMapperUtils.map(bookData, bookDto);
    }
}
