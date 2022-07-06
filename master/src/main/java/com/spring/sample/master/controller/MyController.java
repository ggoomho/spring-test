package com.spring.sample.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.sample.master.service.MyService;


@Controller
public class MyController {
    
    @Autowired
    private MyService service;

    @GetMapping("/test/{param}")
    @ResponseBody
    public ResponseEntity<?> test(@PathVariable("param") int param) {
        return new ResponseEntity<>(service.testMethod(param), HttpStatus.OK);
    }
}
