package com.springdatajpa.demo.exceptionhandling;

import lombok.*;


public class ResourceNotFound extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String resourcefield;
    private String resourceName;
    private int resourceValue;

    public ResourceNotFound (String resourcefield , String resourceName , int resourceValue) {
        super(String.format ("%s not found with %s : %s",resourcefield,resourceName,resourceValue));
        this.resourcefield = resourcefield;
        this.resourceName = resourceName;
        this.resourceValue = resourceValue;
    }


}
