package com.manuel.bookstore.entity;

import com.manuel.bookstore.enumeration.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@MappedSuperclass
@Table(name = "store_user")
public class StoreUserData extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID publicId;
    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public StoreUserData() {}

    public StoreUserData(String name, String email, String password, String address, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
