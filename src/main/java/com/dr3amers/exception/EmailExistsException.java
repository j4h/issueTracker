package com.dr3amers.exception;

/**
 * Created by j4 on 07.11.16.
 */
public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String email) {
        super("Username with email: "+email+" has already exists");
    }

    public String toString(){
        return this.getMessage() +"\n" + getClass();
    }
}
