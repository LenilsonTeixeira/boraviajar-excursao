package br.com.boraviajar.apimanager.exception;

public class ImageLoadException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ImageLoadException(String message){
        super(message);
    }

    public ImageLoadException(String message , Throwable cause){
        super(message,cause);
    }
}
