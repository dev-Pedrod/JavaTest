package com.devpedrod.JavaTest.service.exceptions;

public class CepNotFoundException extends RuntimeException{

    public CepNotFoundException(String msg) {
        super(msg);
    }
}
