package com.training.daos;

public class ElementNotFoundException extends Exception{



   private String errorCode;
    public ElementNotFoundException(String errorCode) {
        super();
        this.errorCode=errorCode;
        }
    @Override
    public String getMessage() {
        return this.errorCode;
    }
}