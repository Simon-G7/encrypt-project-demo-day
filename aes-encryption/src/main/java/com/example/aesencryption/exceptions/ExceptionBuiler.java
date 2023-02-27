package com.example.aesencryption.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ExceptionBuiler {

    private int status;
    private Map<String,String> failures;
    private String path;

    public ExceptionBuiler estatus(int estatus) {
        this.status = estatus;
        return this;
    }

    public ExceptionBuiler status(HttpStatus estatus) {
        this.status = estatus.value();
        return this;
    }

    public ExceptionBuiler errores(Map<String, String> failures) {
        this.failures = failures;
        return this;
    }

    public ExceptionBuiler  exception(MethodArgumentNotValidException ex){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        this.status = status.value();

        this.failures = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            failures.put(fieldName, errorMessage);
        });

        return this;
    }

    public ExceptionBuiler  exception(NoSuchElementException ex){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.status = status.value();

        this.failures = new HashMap<>();

        String fieldName = ex.getLocalizedMessage();
        String errorMessage = ex.getMessage();
        failures.put(fieldName, errorMessage);

        return this;
    }

    public ExceptionBuiler  exception(NullPointerException ex){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        this.status = status.value();

        this.failures = new HashMap<>();

        String fieldName = ex.getLocalizedMessage();
        String errorMessage = ex.getMessage();
        failures.put(fieldName, errorMessage);

        return this;
    }

    public ExceptionBuiler ruta(String ruta) {
        this.path = ruta;
        return this;
    }

    public ExceptionResponse build(){
        ExceptionResponse respuesta  = new ExceptionResponse();

        respuesta.setStatus(this.status);
        respuesta.setFailures(this.failures);
        respuesta.setPath(this.path);

        return respuesta;
    }

    public ResponseEntity<ExceptionResponse> entidad(){
        return ResponseEntity.status(status).headers(HttpHeaders.EMPTY).body(build());
    }

}
