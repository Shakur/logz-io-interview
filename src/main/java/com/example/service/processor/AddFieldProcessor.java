package com.example.service.processor;

import java.util.Map;

public class AddFieldProcessor implements Processor {

    private Map<String, String> configuration;

    @Override
    public void initialize(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    @Override
    public void process(Map<String, Object> jsonDocument) {
        jsonDocument.put(configuration.get("fieldName"), configuration.get("fieldValue"));
    }

}
