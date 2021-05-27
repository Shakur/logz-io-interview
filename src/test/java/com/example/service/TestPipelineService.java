package com.example.service;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class TestPipelineService {

    private PipelineService pipelineService = new PipelineService();

    @Test
    void testTransformAdd() {
        Map<String, Object> jsonDocument = new HashMap<>();
        jsonDocument.put("age", 20);
        jsonDocument.put("city", "New York");
        pipelineService.transform("test.json", jsonDocument);
        System.out.println(jsonDocument);
    }

    @Test
    void testTransformAddReplace() {
        Map<String, Object> jsonDocument = new HashMap<>();
        jsonDocument.put("firstName", "old name");
        jsonDocument.put("city", "New York");
        pipelineService.transform("test.json", jsonDocument);
        System.out.println(jsonDocument);
    }

    @Test
    void testTransformRemove() {
        Map<String, Object> jsonDocument = new HashMap<>();
        jsonDocument.put("age", 20);
        jsonDocument.put("city", "New York");
        pipelineService.transform("test1.json", jsonDocument);
        System.out.println(jsonDocument);
    }

}
