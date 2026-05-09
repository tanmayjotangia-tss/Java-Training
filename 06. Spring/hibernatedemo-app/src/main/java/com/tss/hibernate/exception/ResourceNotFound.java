package com.tss.hibernate.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFound extends ApplicationException{
    public ResourceNotFound(String resource, Object identifier){
        super(resource + " not found: " + identifier, "RESOURCE_NOT_FOUND", HttpStatus.NOT_FOUND);
    }
}
