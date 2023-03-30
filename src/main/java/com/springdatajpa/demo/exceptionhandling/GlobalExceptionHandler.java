package com.springdatajpa.demo.exceptionhandling;

import com.springdatajpa.demo.payload.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ResponseApi> resourceNotFound(ResourceNotFound e, WebRequest webRequest){
        String message = e.getMessage ();

        String pathWithoutdescription = webRequest.getDescription (false);
        ResponseApi api = new ResponseApi (message,false,pathWithoutdescription);

        return new ResponseEntity<ResponseApi> (api, HttpStatus.NOT_FOUND);

    }
}
