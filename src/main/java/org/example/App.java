package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
//        String pathToFile = "C:\\Users\\Алексей\\Desktop\\tickets.json";
//        String pathToFile = "C:\\Users\\Алексей\\Desktop\\test.json";
        String pathToFile = "C:\\Users\\Алексей\\Desktop\\test2.json";
        File file = new File(pathToFile);

        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

        Ticket[] asArray = objectMapper.readValue(file, Ticket[].class);

        // TODO: 15.03.2023 https://www.digitalocean.com/community/tutorials/jackson-json-java-parser-api-example-tutorial

        for (Ticket ticket : asArray) {
            System.out.println(ticket);
        }
    }
}
