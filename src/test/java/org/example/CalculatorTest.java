package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Ticket;
import org.junit.jupiter.api.Test;

import static org.example.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void calculateAverage() {
        assertEquals("14 hours 10 min", testCalculator.calculateAverageTime(TICKETS));
    }

    @Test
    void calculatePercent() {
        assertEquals("13 hours 3 min", testCalculator.calculatePercentOfTime(TICKETS));
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