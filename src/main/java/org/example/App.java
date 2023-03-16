package org.example;

import static org.example.Calculator.calculateAverageTime;
import static org.example.Calculator.calculatePercentOfTime;
import static org.example.JsonParser.getTicketsFromFile;

public class App {
    public static void main(String[] args) {
        Ticket[] tickets = getTicketsFromFile(args[0]);
        if (tickets == null) {
            throw new JsonParserException("Bad format file");
        }
        String averageTime = calculateAverageTime(tickets);
        String percentTime = calculatePercentOfTime(tickets);
        System.out.println("average time is " + averageTime);
        System.out.println("90-percent time is " + percentTime);
    }
}
