package com.manuel.bookstore.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "book_order")
public class OrderData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;
    private String status;
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private PlatformUserData user;

    @ManyToMany
    @JoinTable(
            name = "order_books",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<BookData> books;

    public OrderData() {}

    public OrderData(LocalDate orderDate, String status, BigDecimal totalAmount, PlatformUserData user) {
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.user = user;
    }
}
