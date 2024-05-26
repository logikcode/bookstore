package com.manuel.bookstore.repository;

import com.manuel.bookstore.entity.StoreUserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreUserRepository extends JpaRepository<StoreUserData, Long> {

}
