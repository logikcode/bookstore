package com.manuel.bookstore.service;

import com.manuel.bookstore.dto.BookDto;
import com.manuel.bookstore.dto.request.BookRequest;
import com.manuel.bookstore.entity.AuthorData;
import com.manuel.bookstore.entity.BookData;
import com.manuel.bookstore.entity.PublisherData;
import com.manuel.bookstore.enumeration.Status;
import com.manuel.bookstore.exceptions.DuplicateEntryException;
import com.manuel.bookstore.exceptions.InvalidDataException;
import com.manuel.bookstore.exceptions.NotFoundExceptionBookStore;
import com.manuel.bookstore.repository.AuthorsRepository;
import com.manuel.bookstore.repository.BookCategoryRepository;
import com.manuel.bookstore.repository.BookPublisherRepository;
import com.manuel.bookstore.repository.BookRepository;
import com.manuel.bookstore.utils.ObjectMapperUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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
                    throw new DuplicateEntryException("Book with name already exist", false);
                });

        var bookDto = ObjectMapperUtils.map(request, BookDto.class);
        var categoryData = categoryRepository.findCategoryDataByName(bookDto.getCategoryName())
                .orElseThrow(() -> new NotFoundExceptionBookStore("Please provide valid book category name", false));

        Set<AuthorData> authors = authorsRepository.findAuthorDataByNameIn(request.getAuthorNames());
        authors = !authors.isEmpty() ? authors : getAuthors(request.getAuthorNames());

        var publisherData = publisherRepository.findPublisherDataByName(request.getPublisherName())
                .orElseGet(() -> publisherRepository.save(new PublisherData(UUID.randomUUID(), request.getPublisherName(), "", "", Status.ACTIVE)));

        var bookData = new BookData(UUID.randomUUID(), request.getTitle(), isbnService.generateISBN(), request.getPrice(), LocalDate.now(),
                request.getDescription(), request.getAvailabilityStatus(), authors, publisherData, categoryData);

        bookData = bookRepository.save(bookData);
        categoryData.setBookCategory(bookData);
        publisherData.setBooks(bookData);

        categoryRepository.save(categoryData);
        publisherRepository.save(publisherData);

        return ObjectMapperUtils.map(bookData, bookDto);
    }

    private Set<AuthorData> getAuthors(List<String> authorNames) {
        if (authorNames.isEmpty())
            throw new InvalidDataException("Book author can not be empty, please provide at least one author", false);
        return authorNames.stream()
                .map(AuthorData::new).collect(Collectors.toSet());
    }

    public BookDto update(BookRequest request, UUID publicId) {

        var book = bookRepository.findBookDataByPublicId(publicId)
                .orElseThrow(() -> new NotFoundExceptionBookStore("No matching book with id " + publicId, false));

        Set<String> bookAuthorNames = book.getAuthors().stream()
                .map(a -> a.getName().toLowerCase())
                .collect(Collectors.toSet());

        List<String> filteredAuthorNames = request.getAuthorNames().stream()
                .filter(requestName -> !bookAuthorNames.contains(requestName.toLowerCase()))
                .collect(Collectors.toList());


        if (StringUtils.isNotBlank(request.getCategoryName()) &&
                !request.getCategoryName().equalsIgnoreCase(book.getCategory().getName())) {

            var newCategory = categoryRepository.findCategoryDataByName(request.getCategoryName())
                    .orElseThrow(() -> new NotFoundExceptionBookStore("Please provide valid book category name", false));
            book.setCategory(newCategory);
        }

        if (!filteredAuthorNames.isEmpty()) {
            Set<AuthorData> newAuthors = getAuthors(filteredAuthorNames).stream()
                    .map(authorData -> authorsRepository.findAuthorDataByName(authorData.getName())
                            .orElseGet(() -> authorsRepository.save(authorData)))
                    .collect(Collectors.toSet());
            book.setAuthors(newAuthors);
        }

        var newTitle = StringUtils.isNotBlank(request.getTitle()) &&
                !request.getTitle().equalsIgnoreCase(book.getTitle()) ? request.getTitle() : book.getTitle();
        var newPublisher = StringUtils.isNotBlank(request.getPublisherName()) && (!request.getPublisherName()
                .equalsIgnoreCase(book.getPublisher().getName())) ? getPublisher(request.getPublisherName())
                : book.getPublisher();

        var newPrice = request.getPrice().compareTo(book.getPrice()) != 0 ? request.getPrice() : book.getPrice();

        book.setTitle(newTitle);

        book.setPrice(newPrice);
        newPublisher.setBooks(book);
        var savedPublisher = publisherRepository.save(newPublisher);
        book.setPublisher(savedPublisher);

        var bookDto = ObjectMapperUtils.map(bookRepository.save(book), BookDto.class);

        bookDto.setAuthors(book.getAuthors().stream()
                .map(AuthorData::getName).collect(Collectors.toSet()));
        return bookDto;
    }

    private PublisherData getPublisher(String publisherName) {
        return publisherRepository.findPublisherDataByName(publisherName).orElseGet(() -> new PublisherData(publisherName));

    }
}
