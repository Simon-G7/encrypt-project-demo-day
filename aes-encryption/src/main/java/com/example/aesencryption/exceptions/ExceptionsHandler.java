package com.example.aesencryption.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleStatusException(MethodArgumentNotValidException ex, WebRequest request){
        return ExceptionResponse.builder()
                .exception(ex)
                .ruta(request.getDescription(false).substring(4))
                .entidad();
    }

    @ExceptionHandler( NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ExceptionResponse resourceNotFoundException(NoSuchElementException ex, WebRequest request) {
        return ExceptionResponse.builder()
                .exception(ex)
                .ruta(request.getDescription(false).substring(4))
                .entidad()
                .getBody();
    }

    @ExceptionHandler( NullPointerException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ExceptionResponse resourceNotFoundException(NullPointerException ex, WebRequest request) {
        return ExceptionResponse.builder()
                .exception(ex)
                .ruta(request.getDescription(false).substring(4))
                .entidad()
                .getBody();
    }

}

