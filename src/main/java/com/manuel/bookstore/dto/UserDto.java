package com.manuel.bookstore.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID publicId;
    private String firstName;
    private String lastName;
    private String email;
    private String token;
    private String username;

    public UserDto(){}

    public UserDto(UUID publicId, String firstName, String lastName, String email, String token, String username) {
        this.publicId = publicId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.token = token;
        this.username = username;
    }
}
