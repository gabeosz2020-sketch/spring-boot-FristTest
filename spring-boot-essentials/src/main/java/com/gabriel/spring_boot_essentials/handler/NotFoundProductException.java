package com.gabriel.spring_boot_essentials.handler;

public class NotFoundProductException extends Exception {

    public NotFoundProductException(String message){
        super(message);
    }
}
