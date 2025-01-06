package com.example.demo.myjpasitev4.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    // new ResourceNotFoundException()
    public ResourceNotFoundException() {
        super("리소스를 찾을 수 없습니다.");

    }
}
