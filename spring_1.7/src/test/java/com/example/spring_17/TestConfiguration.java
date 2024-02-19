package com.example.spring_17;

import com.example.spring_17.config.QuestionConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class TestConfiguration {
    @Bean
    QuestionConfig questionConfig() {
        var questionConfig = new QuestionConfig();
        questionConfig.setNumber(1);
        questionConfig.setPath("/example.csv");
        return questionConfig;
    }
}
