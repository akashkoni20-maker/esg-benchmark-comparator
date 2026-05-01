package com.internship.backend.repository;

import com.internship.backend.model.ESGDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ESGRepository extends MongoRepository<ESGDocument, String> {
}