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

    private LocalDate createdDate;
    private LocalDate updatedDate;
    @Column(nullable = false)
    private String createdBy;
    private String updatedBy;

}
