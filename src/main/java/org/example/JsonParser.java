package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;


@UtilityClass
public class JsonParser {
    public static Ticket[] getTicketsFromFile(String pathToFile) {
        File file = new File(pathToFile);

        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(file);
        } catch (IOException e) {
            throw new JsonParserException("Wrong file");
        }
        JsonNode statusNode = jsonNode.get("tickets");
        try {
            return objectMapper.treeToValue(statusNode, Ticket[].class);
        } catch (JsonProcessingException e) {
            throw new JsonParserException("Bad parsing");
        }
    }
}
