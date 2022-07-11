package com.spring.sample.master.common.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MyErrorCode {

    MY_BAD_REQUEST(HttpStatus.BAD_REQUEST, -1, "My Bad Request."),
    My_NOT_FOUND(HttpStatus.NOT_FOUND, -2, "Method Not Found.");

    private HttpStatus httpStatus;
    private int errorCode;
    private String message;
}
