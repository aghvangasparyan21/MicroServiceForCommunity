package com.communties.microserviceforcommunity.exceptions;

public class ParkingAlreadyExistsException extends RuntimeException {
    public ParkingAlreadyExistsException(String message) {
        super(message);
    }
}
