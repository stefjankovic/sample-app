package com.sjankovic.sampleapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjankovic.sampleapp.entities.Poll;
import com.sjankovic.sampleapp.service.PollService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class SampleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PollService pollService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Poll>> typeReference = new TypeReference<>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/polls.json");
            try {
                List<Poll> polls = mapper.readValue(inputStream,typeReference);
                pollService.save(polls);
                System.out.println("Polls Saved!");
            } catch (IOException e){
                System.out.println("Unable to save polls: " + e.getMessage());
            }
        };
    }
}
