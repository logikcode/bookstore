package com.manuel.bookstore.repository;

import com.manuel.bookstore.entity.BookData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookData, Long> {

    Optional<BookData> findBookDataByTitle(String title);
}
