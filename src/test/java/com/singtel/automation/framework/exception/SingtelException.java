package com.singtel.automation.framework.exception;

public class SingtelException extends RuntimeException {
    private static final long serialVersionUID = 539938974032006775L;


    public SingtelException(String message) {
        super(message);
    }

    public SingtelException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public SingtelException(Throwable throwable) {
        super(throwable);
    }


}
