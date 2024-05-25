package com.manuel.bookstore.entity;

import com.manuel.bookstore.enumeration.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Table(name = "orders")
@MappedSuperclass
public class OrderData extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID publicId;
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private StoreUserData user;

    @ManyToMany
    @JoinTable(
            name = "book_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<BookData> books;


    public OrderData() {
    }

    public OrderData(LocalDate orderDate, BigDecimal totalAmount, StoreUserData user) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.user = user;
    }
}
