package com.example.aesencryption.exceptions;

import java.time.LocalDateTime;
import java.util.Map;

public class ExceptionResponse {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private Map<String ,String> failures;
    private String path;

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public static ExceptionBuiler builder() {
        return new ExceptionBuiler();
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, String> getFailures() {
        return failures;
    }

    public void setFailures(Map<String, String> failures) {
        this.failures = failures;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
