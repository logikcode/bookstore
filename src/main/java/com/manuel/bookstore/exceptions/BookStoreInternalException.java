package com.manuel.bookstore.exceptions;

import lombok.Getter;

@Getter
public class BookStoreInternalException extends RuntimeException{

    private final String message;
    private final boolean isPrintStackTrace;

    public BookStoreInternalException(String message, boolean isPrintStackTrace){
        super(message);
        this.message = message;
        this.isPrintStackTrace = isPrintStackTrace;
    }
}
