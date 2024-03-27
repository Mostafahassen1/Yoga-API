package com.example.Yoga.Until;

import org.springframework.http.HttpStatusCode;

public class ApiResponse {
    Object body;
    String message;
    HttpStatusCode statusCode;

    public ApiResponse(Object body, String message,Integer statusCode) {
        this.body = body;
        this.message = message;
        this.statusCode = HttpStatusCode.valueOf(statusCode) ;
    }
}
