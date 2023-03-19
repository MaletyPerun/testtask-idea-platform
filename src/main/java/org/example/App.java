package org.example;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.example.deser.JsonParserException;
import org.example.model.Ticket;
import org.example.service.Calculator;
import org.example.deser.JsonParser;

@Slf4j
public class App {
    public static void main(String[] args) {
        JsonParser parser = new JsonParser();
        Calculator calculator = new Calculator();
        Ticket[] tickets = parser.getTicketsFromFile(args[0]);
//        Ticket[] tickets = getTicketsFromFile(args[0]);
        if (tickets == null) {
            throw new JsonParserException("Bad format file");
        }
//        String averageTime = calculateAverageTime(tickets);
        String averageTime = calculator.calculateAverageTime(tickets);
//        String percentTime = calculatePercentOfTime(tickets);
        String percentTime = calculator.calculatePercentOfTime(tickets);
//        log.info("average time is " + averageTime);
//        log.info("90-percent time is " + percentTime);
        log.info("string");
        System.out.println("average time is " + averageTime);
        System.out.println("90-percent time is " + percentTime);
    }
}
