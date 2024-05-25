package com.manuel.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "store_user")
public class PlatformUserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;


    public PlatformUserData() {}

    public PlatformUserData(String name, String email, String password, String address, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
