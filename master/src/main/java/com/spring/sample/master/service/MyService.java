package com.spring.sample.master.service;

import org.springframework.stereotype.Service;

import com.spring.sample.master.common.error.MyErrorCode;
import com.spring.sample.master.common.exception.MyException;
import com.spring.sample.master.dto.MyDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyService {
    
    public MyDto testMethod(int param) {
        log.info("MyService - testMethod proceeding....");
        
        MyDto myDto = new MyDto();
        myDto.setService("MyService");
        myDto.setMethod("testMethod");
        myDto.setParam(param);

        if(param == 1) {
            throw new MyException(MyErrorCode.MY_BAD_REQUEST);
        }
        //int x = 5/param;

        return myDto;
    }
}
