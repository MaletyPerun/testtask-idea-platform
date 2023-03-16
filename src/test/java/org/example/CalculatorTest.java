package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.example.Calculator.calculateAverageTime;
import static org.example.Calculator.calculatePercentOfTime;
import static org.example.TestData.JSON_STRING;
import static org.example.TestData.TICKETS;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void calculateAverage() {
        assertEquals("14 hours 10 min", calculateAverageTime(TICKETS));
    }

    @Test
    void calculatePercent() {
        assertEquals("14 hours 30 min", calculatePercentOfTime(TICKETS));
    }

    @Test
    void checkParsing() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        JsonNode jsonNode = objectMapper.readTree(JSON_STRING);
        JsonNode statusNode = jsonNode.get("tickets");
        Ticket[] tickets = objectMapper.treeToValue(statusNode, Ticket[].class);
        assertEquals(TICKETS.length, tickets.length);
        assertEquals(TICKETS[0].getArrivalDate(), tickets[0].getArrivalDate());
    }
}