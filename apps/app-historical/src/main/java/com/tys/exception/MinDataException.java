package com.tys.exception;

public class MinDataException extends RuntimeException{
    public MinDataException() {
        super();
    }

    public MinDataException(String message){
        super(message);
    }

    public MinDataException(String message, Throwable cause){
        super(message, cause);
    }

    public MinDataException(Throwable cause){
        super(cause);
    }

    protected MinDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
