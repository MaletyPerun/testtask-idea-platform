package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;


@UtilityClass
public class JsonParser {
    public static Ticket[] getTicketsFromFile(String pathToFile2) throws IOException {
        String pathToFile = "C:\\Users\\Алексей\\Desktop\\tickets.json";
//        String pathToFile = "C:\\Users\\Алексей\\Desktop\\test.json";
//        String pathToFile = "C:\\Users\\Алексей\\Desktop\\test2.json";
        File file = new File(pathToFile);

        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        JsonNode jsonNode = objectMapper.readTree(file);
        JsonNode statusNode = jsonNode.get("tickets");
        return objectMapper.treeToValue(statusNode, Ticket[].class);
    }
}
