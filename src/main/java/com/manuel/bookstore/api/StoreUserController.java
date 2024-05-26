package com.manuel.bookstore.api;

import com.manuel.bookstore.dto.request.StoreUserRequest;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class StoreUserController {

    @PostMapping
    public void registerUser( @Valid @RequestBody StoreUserRequest request){

    }
}
