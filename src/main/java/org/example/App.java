package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.deser.JsonParser;
import org.example.deser.JsonParserException;
import org.example.model.Ticket;
import org.example.service.Calculator;

@Slf4j
public class App {
    public static void main(String[] args) throws AppException {

        JsonParser parser = new JsonParser();
        Calculator calculator = new Calculator();
        Ticket[] tickets = parser.getTicketsFromFile(args[0]);

        if (tickets == null) {
            throw new JsonParserException("Bad format file");
        }

        String averageTime = calculator.calculateAverageTime(tickets);
        String percentTime = calculator.calculatePercentOfTime(tickets);

        if (averageTime == null || percentTime == null) {
            log.error("bad calculate");
            throw new AppException("bad calculate");
        } else {
            log.info("average time is " + averageTime);
            log.info("90-percent time is " + percentTime);
        }
    }
}
