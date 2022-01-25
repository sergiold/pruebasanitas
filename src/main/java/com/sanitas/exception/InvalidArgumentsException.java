package com.sanitas.exception;

public class InvalidArgumentsException extends RuntimeException{
    public InvalidArgumentsException(String arguments){
        super("Arguments ["+ arguments +"] are not valid ");
    }
}
