package com.fabrisio.bluestore.exceptions;

public class SendEmailException extends RuntimeException{

    private static final long serialVersionUID = 1l;

    public SendEmailException(String message, Throwable cause){
        super(message, cause);
    }

    public SendEmailException(String message){
        super(message);
    }

}
