package com.liveasy.loadDemo.exceptionHandling;

public class LoadNotFoundException extends RuntimeException{
    public LoadNotFoundException(String message) {
        super(message);
    }

    public LoadNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoadNotFoundException(Throwable cause) {
        super(cause);
    }
}
