package com.internship.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

@Document(collection = "esg_data")
public class ESGDocument {

    @Id
    private String id;

    @Indexed   // ✅ added index for performance
    private String name;

    private int score;

    // ✅ getters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getScore() { return score; }

    // ✅ setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setScore(int score) { this.score = score; }
}