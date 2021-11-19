package com.mycompany.app.productms.exceptions;

public class InvalidProductNameException extends RuntimeException{

    public InvalidProductNameException(String msg){
        super(msg);
    }

}
