package com.internship.backend.config;

import com.internship.backend.model.ESGDocument;
import com.internship.backend.repository.ESGRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(ESGRepository repository) {
        return args -> {

            if (repository.count() == 0) {

                ESGDocument e1 = new ESGDocument();
                e1.setName("TCS");
                e1.setScore(85);

                ESGDocument e2 = new ESGDocument();
                e2.setName("Infosys");
                e2.setScore(90);

                ESGDocument e3 = new ESGDocument();
                e3.setName("Wipro");
                e3.setScore(78);

                ESGDocument e4 = new ESGDocument();
                e4.setName("HCL");
                e4.setScore(82);

                ESGDocument e5 = new ESGDocument();
                e5.setName("Tech Mahindra");
                e5.setScore(75);

                ESGDocument e6 = new ESGDocument();
                e6.setName("Reliance");
                e6.setScore(88);

                ESGDocument e7 = new ESGDocument();
                e7.setName("Adani");
                e7.setScore(70);

                ESGDocument e8 = new ESGDocument();
                e8.setName("ICICI Bank");
                e8.setScore(86);

                ESGDocument e9 = new ESGDocument();
                e9.setName("HDFC Bank");
                e9.setScore(89);

                ESGDocument e10 = new ESGDocument();
                e10.setName("Axis Bank");
                e10.setScore(80);

                ESGDocument e11 = new ESGDocument();
                e11.setName("SBI");
                e11.setScore(84);

                ESGDocument e12 = new ESGDocument();
                e12.setName("L&T");
                e12.setScore(83);

                ESGDocument e13 = new ESGDocument();
                e13.setName("Bharti Airtel");
                e13.setScore(87);

                ESGDocument e14 = new ESGDocument();
                e14.setName("Maruti");
                e14.setScore(79);

                ESGDocument e15 = new ESGDocument();
                e15.setName("Tata Steel");
                e15.setScore(76);

                repository.save(e1);
                repository.save(e2);
                repository.save(e3);
                repository.save(e4);
                repository.save(e5);
                repository.save(e6);
                repository.save(e7);
                repository.save(e8);
                repository.save(e9);
                repository.save(e10);
                repository.save(e11);
                repository.save(e12);
                repository.save(e13);
                repository.save(e14);
                repository.save(e15);

                System.out.println("✅ Demo data seeded");
            }
        };
    }
}