package com.manuel.bookstore.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class RestResponse {

    private String message;
    private HttpStatusCode status;
    private String title;
    private String path;
    private Map<String, String> errors;
    private String reference;

    private Map<String, Object> extraData = new HashMap<>();

    public RestResponse(String message, HttpStatusCode exceptionCode, String title,
                        String path, String reference, Map<String, String> errors, Map<String, Object> extraData) {
        this.message = message;
        this.status = exceptionCode;
        this.title = title;
        this.path = path;
        this.reference = reference;
        this.errors = errors;
        this.extraData = extraData;

    }

    public RestResponse(String message, HttpStatusCode status, String title, String path, Map<String, Object> extraData) {
        this.message = message;
        this.status = status;
        this.title = title;
        this.path = path;
        this.extraData = extraData;
    }
}
