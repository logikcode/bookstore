package com.manuel.bookstore.enumeration;

public enum BookStatus {
    AVAILABLE("Available"),
    UNAVAILABLE("Unavailable"),
    ARCHIVED("Archived"),
    DELETED("Deleted");

    private String description;

    BookStatus(String description) {
        this.description = description;
    }
}
