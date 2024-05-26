package com.manuel.bookstore.repository;

import com.manuel.bookstore.entity.AuthorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorsRepository extends JpaRepository<AuthorData, Long> {

    Optional<AuthorData> findAuthorDataByName(String authorName);
}
