package com.spring.sample.master.common.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MyErrorCode {

    MY_BAD_REQUEST(HttpStatus.BAD_REQUEST, -1, "My Bad Request.");

    private HttpStatus httpStatus;
    private int errorCode;
    private String message;
}
