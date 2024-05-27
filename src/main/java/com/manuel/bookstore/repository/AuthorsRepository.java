package com.manuel.bookstore.repository;

import com.manuel.bookstore.entity.AuthorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AuthorsRepository extends JpaRepository<AuthorData, Long> {

    Optional<AuthorData> findAuthorDataByName(String authorName);

    @Query("SELECT a FROM AuthorData a WHERE a.name IN :names")
    Set<AuthorData> findAuthorsByNameIn(@Param("names") List<String> names);

    Set<AuthorData> findAuthorDataByNameIn(List<String> names);
}
