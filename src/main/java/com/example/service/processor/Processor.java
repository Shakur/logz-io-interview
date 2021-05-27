package com.example.service.processor;

import java.util.Map;

public interface Processor {

    void initialize(Map<String, String> configuration);
    void process(Map<String, Object> jsonDocument);

}
