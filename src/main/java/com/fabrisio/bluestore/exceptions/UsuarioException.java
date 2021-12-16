package com.fabrisio.bluestore.exceptions;

public class UsuarioException extends Exception{

    private static final long serialVersionUID = 1l;

    public UsuarioException(String message, Throwable cause){
        super(message, cause);
    }

    public UsuarioException(String message){
        super(message);
    }

}
