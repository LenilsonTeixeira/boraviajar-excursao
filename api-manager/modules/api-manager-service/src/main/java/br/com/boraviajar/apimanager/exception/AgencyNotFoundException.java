package br.com.boraviajar.apimanager.exception;

import org.springframework.http.HttpStatus;

public class AgencyNotFoundException extends BaseException {

    private static final long serialVersionUID = 1L;

    public AgencyNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
