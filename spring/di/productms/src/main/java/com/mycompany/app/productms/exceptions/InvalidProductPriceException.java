package com.mycompany.app.productms.exceptions;

public class InvalidProductPriceException extends RuntimeException{
    public InvalidProductPriceException(String msg){
        super(msg);
    }
}
