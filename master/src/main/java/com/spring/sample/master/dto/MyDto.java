package com.spring.sample.master.dto;

import lombok.Data;

@Data
public class MyDto {
    private String service;
    private String method;
    private int param;
}
