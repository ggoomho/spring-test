package com.spring.sample.master.common.aop;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.spring.sample.master.dto.MyUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class DecodeAspect {
    
    @Pointcut("@annotation(com.spring.sample.master.common.aop.annotation.Decode)")
    public void cut() {}

    @Before("cut()")
    public void before(JoinPoint jp) throws UnsupportedEncodingException {
        Object[] args = jp.getArgs();

        for(Object obj: args) {
            if(obj instanceof MyUser) {
                MyUser myUser = MyUser.class.cast(obj);

                String decodedEmail =  myUser.getEmail();
                String email = new String(Base64.getDecoder().decode(decodedEmail), "UTF-8");

                myUser.setEmail(email);
            }
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObject")
    public void after(JoinPoint jp, Object returnObject) throws UnsupportedEncodingException {
        if(returnObject instanceof MyUser) {
            MyUser myUser = MyUser.class.cast(returnObject);

            String email = myUser.getEmail();
            String encodedEmail = Base64.getEncoder().encodeToString(email.getBytes());

            myUser.setEmail(encodedEmail);
        }
    }
}
