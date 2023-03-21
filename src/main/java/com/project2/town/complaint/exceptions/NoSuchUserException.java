package com.project2.town.complaint.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class NoSuchUserException extends Exception{
    public NoSuchUserException(){
        super("No such User");
    }
}
