package br.com.boraviajar.apimanager.exception;

public class ImageReadException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ImageReadException(String message){
        super(message);
    }

    public ImageReadException(String message , Throwable cause){
        super(message,cause);
    }
}
