package com.studyproject.tasklist.domain.exception;

public class AccessDeniedException extends RuntimeException{
    public AccessDeniedException() {
        super("Access denied");
    }
}
