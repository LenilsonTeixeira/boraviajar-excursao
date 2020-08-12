package br.com.boraviajar.apimanager.exception;

import org.springframework.http.HttpStatus;

public class AgencyValidatorException extends BaseException {

    private static final long serialVersionUID = 1L;

    public AgencyValidatorException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.PRECONDITION_FAILED;
    }

}
