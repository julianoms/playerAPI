package com.playerAPI.exceptions;

public class PlayerApiException extends RuntimeException {

    public PlayerApiException(String message, Throwable e) {
        super(message, e);
    }
}
