package com.manuel.bookstore.exceptions;

import lombok.Getter;

@Getter
public class DuplicateEntryExceptionBookStore extends BookStoreInternalException {

    private String message;
    private boolean isStackTrace;

    public DuplicateEntryExceptionBookStore(String message, boolean printStackTrace){
        super(message, printStackTrace);
        this.message = message;
        this.isStackTrace = printStackTrace;
    }
}
