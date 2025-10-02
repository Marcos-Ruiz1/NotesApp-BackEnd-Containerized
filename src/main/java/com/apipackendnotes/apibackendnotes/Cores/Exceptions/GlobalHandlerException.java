package com.apipackendnotes.apibackendnotes.Cores.Exceptions;

import com.apipackendnotes.apibackendnotes.Cores.EntityResponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {


    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ApiResponse<Object>> HttpException(HttpException ex){
        return ResponseEntity.status(ex.getStatus()).body(ApiResponse.error(ex.getStatus().value(), ex.getMessage()));
    }
}
