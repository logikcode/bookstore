package com.manuel.bookstore.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ISBNService {

    private static final String ISBN_PREFIX = "978"; // Prefix for ISBN-13

    public String generateISBN() {

        var isbn = new StringBuilder(ISBN_PREFIX);
        var random = new Random();

        // Generate the first 9 random digits
        for (int i = 0; i < 9; i++) {
            isbn.append(random.nextInt(10));
        }

        int checksum = calculateChecksum(isbn.toString());
        isbn.append(checksum);

        return isbn.toString();
    }

    private int calculateChecksum(String isbn) {
        int sum = 0;

        // ISBN-13 uses a weighted sum calculation
        for (int i = 0; i < isbn.length(); i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }

        // The checksum digit is the amount needed to round the sum up to the nearest 10
        int checksum = 10 - (sum % 10);
        return (checksum == 10) ? 0 : checksum;
    }
}
