package com.communties.microserviceforcommunity.exceptions;

public class CommunityAlreadyExistsException extends RuntimeException {
    public CommunityAlreadyExistsException(String message) {
        super(message);
    }
}
