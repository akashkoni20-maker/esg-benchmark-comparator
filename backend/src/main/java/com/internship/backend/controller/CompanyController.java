package com.internship.backend.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
public class CompanyController {

    @GetMapping("/companies")
    public List<Map<String,String>> getCompanies(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate
    ) {

        List<Map<String,String>> list = new ArrayList<>();

        Map<String,String> a = new HashMap<>();
        a.put("id","1");
        a.put("name","Tesla");
        a.put("status","Active");
        a.put("date","2026-04-20");

        Map<String,String> b = new HashMap<>();
        b.put("id","2");
        b.put("name","Infosys");
        b.put("status","Inactive");
        b.put("date","2026-04-22");

        list.add(a);
        list.add(b);

        return list;
    }
}