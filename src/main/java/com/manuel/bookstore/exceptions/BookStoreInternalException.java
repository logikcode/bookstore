package com.manuel.bookstore.exceptions;

import lombok.Getter;

@Getter

public class BookStoreInternalException extends RuntimeException{

    private  String message;
    private  boolean isPrintStackTrace;

    public BookStoreInternalException(){}
    public BookStoreInternalException(String message, boolean isPrintStackTrace){
        super(message);
        this.message = message;
        this.isPrintStackTrace = isPrintStackTrace;
    }
}
