package br.com.boraviajar.apimanager.exception;

import org.springframework.http.HttpStatus;

public class TravelValidatorException extends BaseException {

    private static final long serialVersionUID = 1L;

    public TravelValidatorException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.PRECONDITION_FAILED;
    }
}
