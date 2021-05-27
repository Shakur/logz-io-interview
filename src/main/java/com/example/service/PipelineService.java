package com.example.service;

import com.example.model.PipelineDescriptor;
import com.example.service.mapper.JsonToPipelineDescriptorMapper;

import java.util.Map;

public class PipelineService {

    private JsonToPipelineDescriptorMapper mapper;
    private PipelineExecutor pipelineExecutor;

    public PipelineService() {
        this.mapper = new JsonToPipelineDescriptorMapper();
        this.pipelineExecutor = new PipelineExecutor();
    }

    public void transform(String fileName, Map<String, Object> jsonDocument) {
        PipelineDescriptor pipelineDescriptor = mapper.map(fileName);
        pipelineExecutor.transform(pipelineDescriptor, jsonDocument);
    }

}
