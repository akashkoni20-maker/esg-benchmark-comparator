package com.internship.backend.controller;

import com.internship.backend.model.ESGDocument;
import com.internship.backend.repository.ESGRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ESGController {

    private final ESGRepository repository;

    public ESGController(ESGRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ESGDocument data) {
        return ResponseEntity.ok(repository.save(data));
    }

    @GetMapping("/all")
    public List<ESGDocument> getAll() {
        return repository.findAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id,
                                    @RequestBody ESGDocument data) {
        data.setId(id);
        return ResponseEntity.ok(repository.save(data));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}