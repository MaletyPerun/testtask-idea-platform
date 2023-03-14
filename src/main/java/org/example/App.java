package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
//        String pathToFile = "C:\\Users\\Алексей\\Desktop\\tickets.json";
        String pathToFile = "C:\\Users\\Алексей\\Desktop\\test.json";
        File file = new File(pathToFile);
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());


//        JsonMapper jsonMapper = new JsonMapper();
//        jsonMapper.registerModule(new JavaTimeModule());


//        List<Ticket> employeeList = (List<Ticket>) objectMapper.readValue(file, new TypeReference<Ticket>(){});
        Ticket ticket = objectMapper.readValue(file, Ticket.class);
        System.out.println(ticket);
//        System.out.println(employeeList);
//        readFile(pathToFile);
//        parseObjects();
//        calculateAverange();
//        calculatePercent();
//        print();
    }
}
