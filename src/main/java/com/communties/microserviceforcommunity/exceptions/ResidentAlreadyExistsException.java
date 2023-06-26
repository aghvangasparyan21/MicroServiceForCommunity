package com.communties.microserviceforcommunity.exceptions;

public class ResidentAlreadyExistsException extends RuntimeException {
    public ResidentAlreadyExistsException(String message) {
        super(message);
    }
}
