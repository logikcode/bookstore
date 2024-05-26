package com.manuel.bookstore.dto;


import lombok.Data;


@Data
public class StoreUserDto {

    private String name;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;
    public StoreUserDto(String name, String email, String password, String address, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
