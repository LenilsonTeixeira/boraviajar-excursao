package br.com.boraviajar.apimanager.exception;

import org.springframework.http.HttpStatus;

public class TravelNotFoundException extends BaseException {

    private static final long serialVersionUID = 1L;

    public TravelNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}