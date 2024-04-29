package io.carmanufacturing.A1Infrastructure.exceptions;

public class UnauthorizedException extends  RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
