CREATE TABLE esg_records (
 id BIGSERIAL PRIMARY KEY,
 company_name VARCHAR(255) NOT NULL,
 industry VARCHAR(150),
 country VARCHAR(100),
 environmental_score DECIMAL(5,2),
 social_score DECIMAL(5,2),
 governance_score DECIMAL(5,2),
 overall_score DECIMAL(5,2),
 benchmark_rank INT,
 status VARCHAR(50) DEFAULT 'ACTIVE',
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_company_name ON esg_records(company_name);
CREATE INDEX idx_industry ON esg_records(industry);
CREATE INDEX idx_country ON esg_records(country);
CREATE INDEX idx_status ON esg_records(status);