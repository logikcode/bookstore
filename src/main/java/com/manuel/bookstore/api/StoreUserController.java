package com.manuel.bookstore.api;

import com.manuel.bookstore.dto.LoginDto;
import com.manuel.bookstore.dto.UserDto;
import com.manuel.bookstore.dto.request.UserRegistrationRequest;

import com.manuel.bookstore.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class StoreUserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserDto registerUser(@Valid @RequestBody UserRegistrationRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody LoginDto dto) {
        return userService.login(dto);

    }


}
