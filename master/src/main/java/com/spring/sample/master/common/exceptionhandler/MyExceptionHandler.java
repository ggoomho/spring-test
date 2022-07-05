package com.spring.sample.master.common.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.sample.master.common.error.MyErrorResponse;
import com.spring.sample.master.common.exception.MyException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {
    
    @ExceptionHandler(MyException.class)
    public ResponseEntity<MyErrorResponse> handleMyException(MyException e) {
        log.info("CATCH MY_EXCEPTION IN EXCEPTION HANDLER");
        MyErrorResponse errorResponse = MyErrorResponse.of(e.getErrorCode());
        return ResponseEntity.status(errorResponse.getHttpStatus()).body(errorResponse);
    }
}
