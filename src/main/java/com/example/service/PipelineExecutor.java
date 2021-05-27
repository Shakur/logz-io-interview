package com.example.service;

import com.example.model.PipelineDescriptor;
import com.example.model.Step;
import com.example.service.factory.ProcessorFactory;
import com.example.service.factory.ProcessorFactoryImpl;
import com.example.service.processor.Processor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PipelineExecutor {

    private ProcessorFactory processorFactory = new ProcessorFactoryImpl();

    public void transform(PipelineDescriptor pipelineDescriptor, Map<String, Object> jsonDocument){
        List<Step> steps = pipelineDescriptor.getSteps();

        Map<Processor, Map<String, String>> processorConfig = steps.stream()
                .collect(Collectors.toMap(
                        step -> processorFactory.create(step.getProcessor()),
                        Step::getConfiguration,
                        (x, y) -> y, LinkedHashMap::new));

        processorConfig.entrySet().forEach(entry -> {
            Processor processor = entry.getKey();
            processor.initialize(entry.getValue());
            processor.process(jsonDocument);
        });
    }

}
