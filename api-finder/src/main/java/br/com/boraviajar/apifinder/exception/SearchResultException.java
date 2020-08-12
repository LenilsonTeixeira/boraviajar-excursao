package br.com.boraviajar.apifinder.exception;

public class SearchResultException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public SearchResultException(String message){
        super(message);
    }

    public SearchResultException(String message , Throwable cause){
        super(message,cause);
    }
}
