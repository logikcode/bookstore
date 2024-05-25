package com.manuel.bookstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDate createdDate;

    @Column(nullable = false)
    private String createdBy;

    private LocalDate updatedDate;

    private String updatedBy;

}
