package com.spring.sample.master.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.sample.master.common.error.MyErrorCode;

import lombok.Getter;

// @ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class MyException extends RuntimeException {
    private MyErrorCode errorCode;

    public MyException(MyErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}


