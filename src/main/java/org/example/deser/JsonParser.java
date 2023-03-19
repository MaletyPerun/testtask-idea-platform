package org.example.deser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Ticket;

import java.io.File;
import java.io.IOException;


public class JsonParser {
    public Ticket[] getTicketsFromFile(String pathToFile) {
        File file = new File(pathToFile);

        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
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
