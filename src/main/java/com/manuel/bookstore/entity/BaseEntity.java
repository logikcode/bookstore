package com.manuel.bookstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseEntity {
    @Column(nullable = false)
    private LocalDate createdDate = LocalDate.now();
    private LocalDate updatedDate = LocalDate.now();
    @Column(nullable = false)
    private String createdBy = "Admin";
    private String updatedBy;

}
