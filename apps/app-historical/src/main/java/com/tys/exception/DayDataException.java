package com.tys.exception;

public class DayDataException extends RuntimeException{
    public DayDataException() {
        super();
    }

    public DayDataException(String message){
        super(message);
    }

    public DayDataException(String message, Throwable cause){
        super(message, cause);
    }

    public DayDataException(Throwable cause){
        super(cause);
    }

    protected DayDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
