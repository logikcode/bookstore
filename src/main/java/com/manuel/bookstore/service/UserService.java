package com.manuel.bookstore.service;


import com.manuel.bookstore.config.security.UserAuthProvider;
import com.manuel.bookstore.dto.LoginDto;
import com.manuel.bookstore.dto.UserDto;
import com.manuel.bookstore.dto.request.UserRegistrationRequest;
import com.manuel.bookstore.entity.StoreUserData;
import com.manuel.bookstore.exceptions.InvalidDataException;
import com.manuel.bookstore.exceptions.NotFoundException;
import com.manuel.bookstore.repository.StoreUserRepository;
import com.manuel.bookstore.utils.ObjectMapperUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final StoreUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthProvider userAuthProvider;

    public UserService(StoreUserRepository userRepository, PasswordEncoder passwordEncoder, UserAuthProvider userAuthProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userAuthProvider = userAuthProvider;
    }

    public UserDto login(LoginDto loginDto) {

        var user = userRepository.findStoreUserDataByEmail(loginDto.email())
                .orElseThrow(() -> new NotFoundException("User does not exist", false));

        if (passwordEncoder.matches(loginDto.password(), user.getPassword())) {
            var userDto = ObjectMapperUtils.map(user, UserDto.class);
            userDto.setToken(userAuthProvider.createToken(userDto));
            return userDto;
        }
        throw new InvalidDataException("Invalid user credentials", false);
    }

    public UserDto register(UserRegistrationRequest request) {

        var optionalUser = userRepository.findStoreUserDataByEmail(request.getEmail());
        if (optionalUser.isPresent())
            throw new NotFoundException("User already exist with " + request.getEmail(), false);

        var userData = ObjectMapperUtils.map(request, StoreUserData.class);
        userData.setPassword(passwordEncoder.encode(request.getPassword()));
        userData.setPublicId(UUID.randomUUID());
        var savedUser = userRepository.save(userData);
        return ObjectMapperUtils.map(savedUser, UserDto.class);
    }
}
