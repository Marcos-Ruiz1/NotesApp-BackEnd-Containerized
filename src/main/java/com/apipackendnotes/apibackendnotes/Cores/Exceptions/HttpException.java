package com.apipackendnotes.apibackendnotes.Cores.Exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class HttpException extends RuntimeException{

    private final HttpStatus status;

    //this public can be actually 'private'
    public HttpException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }



    //Methods to simplify the creation of the HttpException object
    public static HttpException badRequest(String message){
        return new HttpException(message, HttpStatus.BAD_REQUEST);
    }
    public static HttpException notFound(String message){
        return new HttpException(message, HttpStatus.NOT_FOUND);
    }
    public static HttpException internalServerError(String message){
        return new HttpException(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
