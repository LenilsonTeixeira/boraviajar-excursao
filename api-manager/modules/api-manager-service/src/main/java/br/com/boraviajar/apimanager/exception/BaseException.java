package br.com.boraviajar.apimanager.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BaseException(final String message) {
        super(message);
    }

    public BaseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getStatus();

}
