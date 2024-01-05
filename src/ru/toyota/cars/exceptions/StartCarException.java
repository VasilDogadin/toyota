package ru.toyota.cars.exceptions;

public final class StartCarException extends Exception {

    public StartCarException() {
    }

    public StartCarException(String message, Object... args) {
        super(String.format(message, args));
    }

    public StartCarException(Throwable cause, String message, Object... args) {
        super(String.format(message, args), cause);
    }

    public StartCarException(Throwable cause) {
        super(cause);
    }
}
