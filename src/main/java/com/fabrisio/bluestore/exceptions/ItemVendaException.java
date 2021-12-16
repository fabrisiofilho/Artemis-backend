package com.fabrisio.bluestore.exceptions;

public class ItemVendaException extends Exception{

    private static final long serialVersionUID = 1l;

    public ItemVendaException(String message, Throwable cause){
        super(message, cause);
    }

    public ItemVendaException(String message){
        super(message);
    }

}
