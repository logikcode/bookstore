package com.manuel.bookstore.repository;

import com.manuel.bookstore.entity.ReviewData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository extends JpaRepository<ReviewData, Long> {

}
