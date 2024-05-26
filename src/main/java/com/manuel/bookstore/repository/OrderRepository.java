package com.manuel.bookstore.repository;

import com.manuel.bookstore.entity.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderData, Long> {

}
