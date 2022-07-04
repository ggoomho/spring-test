package com.spring.sample.master.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    
    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
