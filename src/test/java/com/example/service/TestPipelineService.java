package com.example.service;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPipelineService {

    private PipelineService pipelineService = new PipelineService();

    @Test
    void testTransformAdd() {
        Map<String, Object> jsonDocument = new HashMap<>();
        jsonDocument.put("age", 20);
        jsonDocument.put("city", "New York");
        jsonDocument.put("country", "USA");
        pipelineService.transform("test.json", jsonDocument);
        assertAll(
                () -> assertEquals("George", jsonDocument.get("firstName")),
                () -> assertEquals("New York", jsonDocument.get("city")),
                () -> assertEquals("USA", jsonDocument.get("country")),
                () -> assertEquals(20, jsonDocument.get("age")),
                () -> assertEquals(4, jsonDocument.get("numOfFields"))
        );
    }

    @Test
    void testTransformAddReplace() {
        Map<String, Object> jsonDocument = new HashMap<>();
        jsonDocument.put("firstName", "old name");
        jsonDocument.put("city", "New York");
        pipelineService.transform("test.json", jsonDocument);
        assertAll(
                () -> assertEquals("George", jsonDocument.get("firstName")),
                () -> assertEquals("New York", jsonDocument.get("city")),
                () -> assertEquals(2, jsonDocument.get("numOfFields"))
        );
    }

    @Test
    void testTransformRemove() {
        Map<String, Object> jsonDocument = new HashMap<>();
        jsonDocument.put("age", 20);
        jsonDocument.put("city", "New York");
        pipelineService.transform("test1.json", jsonDocument);
        assertAll(
                () -> assertEquals("New York", jsonDocument.get("city")),
                () -> assertEquals(1, jsonDocument.get("numOfFields"))
        );
    }

}
