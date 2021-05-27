package com.example.service.factory;

import com.example.service.processor.AddFieldProcessor;
import com.example.service.processor.CountNumOfFieldsProcessor;
import com.example.service.processor.Processor;
import com.example.service.processor.RemoveFieldProcessor;

public class ProcessorFactoryImpl implements ProcessorFactory {

    @Override
    public Processor create(String processorName) {
        switch (processorName) {
            case "AddField":
                return new AddFieldProcessor();
            case "RemoveField":
                return new RemoveFieldProcessor();
            case "CountNumOfFields":
                return new CountNumOfFieldsProcessor();
            default:
                throw new RuntimeException("Processor is unknown");
        }
    }
}
