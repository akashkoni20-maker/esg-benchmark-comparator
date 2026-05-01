package com.internship.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "esg_data")
public class ESGDocument {

    @Id
    private String id;
    private String name;
    private String score;

    // ✅ getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getScore() { return score; }

    // ✅ setters (IMPORTANT)
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setScore(String score) { this.score = score; }
}