package com.springdatajpa.demo.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ResponseApi {
    private String message;
    private boolean success;

    private String path;

    public ResponseApi (String message , boolean success , String path) {
        this.message = message;
        this.success = success;
        this.path=path;
    }

    public ResponseApi(){

    }
}
