package com.internship.backend.service;

import com.internship.backend.model.ESGDocument;
import com.internship.backend.repository.ESGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ESGService {

    @Autowired
    private ESGRepository repository;

    public ESGDocument save(ESGDocument data) {
        return repository.save(data);
    }

    public List<ESGDocument> getAll() {
        return repository.findAll();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}