package com.spring.sample.master.service;

import org.springframework.stereotype.Service;

import com.spring.sample.master.common.aop.annotation.MyServiceLog;
import com.spring.sample.master.common.error.MyErrorCode;
import com.spring.sample.master.common.exception.MyException;
import com.spring.sample.master.dto.MyUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyService {
    
    @MyServiceLog
    public int testGetMethod(int param) {
        log.info("MyService - testMethod proceeding....");
        
        if(param == 1) {
            throw new MyException(MyErrorCode.MY_BAD_REQUEST);
        }
        //int x = 5/param;

        return param;
    }

    @MyServiceLog
    public MyUser testPostMethod(MyUser myUser) {
        log.info("user name: " + myUser.getName());
        log.info("user email: " + myUser.getEmail());
        log.info("user age: " + myUser.getAge());
        return myUser;
    }
}
