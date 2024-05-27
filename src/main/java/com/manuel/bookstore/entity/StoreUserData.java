package com.manuel.bookstore.entity;

import com.manuel.bookstore.enumeration.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "store_users")
public class StoreUserData extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID publicId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private LocalDate registrationDate = LocalDate.now();
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.ACTIVE;

    public StoreUserData() {}

    public StoreUserData(String firstName, String lastName, String email, String password, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
