package com.spring.sample.master.common.error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MyErrorController implements ErrorController {
    
    @RequestMapping(value = "/error")
    public ResponseEntity<MyErrorResponse> handleError(HttpServletRequest request, HttpServletResponse response) {

        int status = response.getStatus();
        
        log.info("status: " + status);
        log.info("path: " + request.getRequestURI());

        MyErrorResponse myErrorResponse = null;

        switch(status) {
            case 404:
                myErrorResponse = MyErrorResponse.of(MyErrorCode.My_NOT_FOUND);
                return ResponseEntity.status(myErrorResponse.getHttpStatus()).body(myErrorResponse);
            default:
                return null;
            
        }
    }
}


