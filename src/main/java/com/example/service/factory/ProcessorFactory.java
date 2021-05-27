package com.example.service.factory;

import com.example.service.processor.Processor;

public interface ProcessorFactory {
    Processor create(String processorName);
}