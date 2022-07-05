package com.spring.sample.master.common.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MyErrorResponse {
    private HttpStatus httpStatus;
    private int errorCode;
    private String message;

    public static MyErrorResponse of(MyErrorCode errorCode) {
        return new MyErrorResponse(errorCode.getHttpStatus(), errorCode.getErrorCode(), errorCode.getMessage());
    }
}
