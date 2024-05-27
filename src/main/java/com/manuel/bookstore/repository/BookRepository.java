package com.manuel.bookstore.repository;

import com.manuel.bookstore.entity.BookData;
import com.manuel.bookstore.enumeration.BookStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookData, Long> {

    Optional<BookData> findBookDataByTitle(String title);

    Optional<BookData> findBookDataByPublicId(UUID publicId);

    Page<BookData> findByAvailabilityStatus(BookStatus bookStatus, Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE BookData b SET b.availabilityStatus = 'DELETED' WHERE b.publicId = :publicId")
    void deleteBookByPublicId(@Param("publicId") UUID publicId);

    @Modifying
    @Transactional
    @Query("UPDATE BookData b SET b.availabilityStatus = :status WHERE b.publicId = :publicId")
    void  updateStatusByPublicId(@Param("publicId") UUID publicId, @Param("status") BookStatus status);

}
