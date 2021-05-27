package com.example.service.mapper;

import com.example.model.PipelineDescriptor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonToPipelineDescriptorMapper {

    public PipelineDescriptor map(String fileName) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            File jsonFile = new File(getClass().getClassLoader().getResource(fileName).getFile());
            return mapper.readValue(jsonFile, PipelineDescriptor.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse " + fileName);
        }
    }

}
