package com.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Step {

    private String processor;
    private Map<String, String> configuration;

}
