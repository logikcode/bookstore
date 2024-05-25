package com.manuel.bookstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@MappedSuperclass
@Table(name = "category")
public class CategoryData extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<BookData> books;

    public CategoryData() {}

    public CategoryData(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
