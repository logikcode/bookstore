package com.manuel.bookstore.repository;

import com.manuel.bookstore.entity.CategoryData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookCategoryRepository extends JpaRepository<CategoryData, Long> {

    Optional<CategoryData> findCategoryDataByName(String categoryName);
}
