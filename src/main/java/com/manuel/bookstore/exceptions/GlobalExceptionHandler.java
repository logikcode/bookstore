package com.manuel.bookstore.exceptions;

import com.manuel.bookstore.dto.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        BindingResult result = ex.getBindingResult();
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : result.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        var path = request.getDescription(false).substring(4);
        var errorResponse = new RestResponse("Bad Request", status, "Invalid request content.",
                path, "", errors, Map.of());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RestResponse> handleNotFoundException(BookStoreInternalException ex, HttpStatusCode status,
                                                                WebRequest request) {

        log.info(ex.getMessage(), ex.isPrintStackTrace() ? ex.getStackTrace() : getStackTrace(ex));
        var response = new RestResponse(ex.getMessage(),status, ex.getMessage(),
                 request.getDescription(false).substring(4),  Map.of());

        return new ResponseEntity<>(response, NOT_FOUND);
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<RestResponse> handleDuplicateException(BookStoreInternalException ex,  HttpStatusCode status,
                                                                 WebRequest request) {

        log.info(ex.getMessage(), ex.isPrintStackTrace() ? ex.getStackTrace() : getStackTrace(ex));
        var response = new RestResponse(ex.getMessage(), status, ex.getMessage(),
                request.getDescription(false).substring(4),  Map.of());

        return new ResponseEntity<>(response, CONFLICT);
    }

    @ExceptionHandler(InvalidDataException .class)
    public ResponseEntity<RestResponse> handleInvalidDataException(BookStoreInternalException ex,  HttpStatusCode status,
                                                                 WebRequest request) {

        log.info(ex.getMessage(), ex.isPrintStackTrace() ? ex.getStackTrace() : getStackTrace(ex));
        var response = new RestResponse(ex.getMessage(), status, ex.getMessage(),
                request.getDescription(false).substring(4),  Map.of());

        return new ResponseEntity<>(response, CONFLICT);
    }


    private String getStackTrace(BookStoreInternalException ex) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int x = 0; x < 5; x++) {
            var stackTraceElement = ex.getStackTrace()[x];
            stringBuilder.append(stackTraceElement).append("\n");
        }

        return stringBuilder.toString();
    }
}
