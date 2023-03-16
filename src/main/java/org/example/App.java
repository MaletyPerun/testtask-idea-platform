package org.example;

import java.io.IOException;
import java.time.LocalTime;

import static org.example.Calculator.calculateAverageTime;
import static org.example.Calculator.calculatePercentOfTime;
import static org.example.JsonParser.getTicketsFromFile;

public class App {
    public static void main(String[] args) throws IOException {
//        Ticket[] tickets = getTicketsFromFile(args[0]);
        Ticket[] tickets = getTicketsFromFile("args[0]");
        LocalTime averageTime = calculateAverageTime(tickets);
        LocalTime percentTime = calculatePercentOfTime(tickets);
        System.out.println("average time is " + averageTime);
        System.out.println("90-percent time is " + percentTime);

        // TODO: 15.03.2023 https://www.digitalocean.com/community/tutorials/jackson-json-java-parser-api-example-tutorial


    }
}
