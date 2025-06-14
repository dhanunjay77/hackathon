package com.hackathon.exception;

public class TimeSheetNotFoundException extends RuntimeException {
    public TimeSheetNotFoundException(String message) {
        super(message);
    }
}

