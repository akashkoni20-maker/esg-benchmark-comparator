package com.internship.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class StatsController {

    @GetMapping("/stats")
    public Map<String, Object> getStats() {

        Map<String, Object> map = new HashMap<>();

        map.put("totalCompanies", 20);
        map.put("avgScore", 78);
        map.put("highESG", 12);
        map.put("lowESG", 8);

        return map;
    }
}