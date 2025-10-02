package com.apipackendnotes.apibackendnotes.Cores.EntityResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private String message;
    private int statusCode;
    private String error;
    private T data;
    private LocalDateTime timestamp;


    //Constructor for Successful response
    public ApiResponse(String message, int statusCode, T data) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    //Constructor for error response
    public ApiResponse(int statusCode, String error) {
        this.statusCode = statusCode;
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }


    //Factory methods
    public static <T> ApiResponse<T> success(String message, T data){
        return new ApiResponse<>(message, HttpStatus.OK.value(), data);
    }

    public static <T> ApiResponse<T> error(int statusCode, String error){
        return new ApiResponse<>(statusCode, error);
    }




}
