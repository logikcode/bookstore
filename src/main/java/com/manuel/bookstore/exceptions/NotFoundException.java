package com.manuel.bookstore.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends BookStoreInternalException {

    private String message;
    private boolean isStackTrace;

    public NotFoundException(String message, boolean printStackTrace){
        super(message, printStackTrace);
        this.message = message;
        this.isStackTrace = printStackTrace;
    }
}
