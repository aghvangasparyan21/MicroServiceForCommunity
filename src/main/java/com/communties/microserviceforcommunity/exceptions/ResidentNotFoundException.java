package com.communties.microserviceforcommunity.exceptions;

public class ResidentNotFoundException extends RuntimeException {
    public ResidentNotFoundException(String message) {
        super(message);
    }
}
