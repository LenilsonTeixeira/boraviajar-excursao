package br.com.boraviajar.apimanager.exception;

public class TravelException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TravelException(String message){
        super(message);
    }

    public TravelException(String message , Throwable cause){
        super(message,cause);
    }
}
