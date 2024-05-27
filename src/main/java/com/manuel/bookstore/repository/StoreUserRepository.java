package com.manuel.bookstore.repository;

import com.manuel.bookstore.entity.StoreUserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreUserRepository extends JpaRepository<StoreUserData, Long> {

    Optional<StoreUserData> findStoreUserDataByEmail(String email);
}
