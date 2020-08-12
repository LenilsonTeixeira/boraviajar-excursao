package br.com.boraviajar.apimanager.exception;

public class AgencyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AgencyException(String message){
        super(message);
    }

    public AgencyException(String message , Throwable cause){
        super(message,cause);
    }
}
