package org.example;

import org.example.model.Ticket;
import org.example.service.Calculator;
import org.example.deser.JsonParser;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.example.util.Formatter.DATE_FORMATTER;
import static org.example.util.Formatter.TIME_FORMATTER;

public class TestData {

    public static final JsonParser testParser = new JsonParser();
    public static final Calculator testCalculator = new Calculator();


    public static final String JSON_STRING = """
            {
              "tickets": [
              {
                "origin": "VVO",
                "origin_name": "Владивосток",
                "destination": "TLV",
                "destination_name": "Тель-Авив",
                "departure_date": "12.05.18",
                "departure_time": "16:20",
                "arrival_date": "12.05.18",
                "arrival_time": "22:10",
                "carrier": "TK",
                "stops": 3,
                "price": 12400
              }, {
                "origin": "VVO",
                "origin_name": "Владивосток",
                "destination": "TLV",
                "destination_name": "Тель-Авив",
                "departure_date": "12.05.18",
                "departure_time": "17:20",
                "arrival_date": "12.05.18",
                "arrival_time": "23:50",
                "carrier": "S7",
                "stops": 1,
                "price": 13100
              }
             ]
            }
            """;

    public static final Ticket TICKET_1 = new Ticket(
            "VVO",
            "Владивосток",
            "TLV",
            "Тель-Авив",
            LocalDate.parse("12.05.18", DATE_FORMATTER),
            LocalTime.parse("16:20", TIME_FORMATTER),
            LocalDate.parse("12.05.18", DATE_FORMATTER),
            LocalTime.parse("22:10", TIME_FORMATTER),
            "TK",
            3,
            12400);

    public static final Ticket TICKET_2 = new Ticket(
            "VVO",
            "Владивосток",
            "TLV",
            "Тель-Авив",
            LocalDate.parse("12.05.18", DATE_FORMATTER),
            LocalTime.parse("17:20", TIME_FORMATTER),
            LocalDate.parse("12.05.18", DATE_FORMATTER),
            LocalTime.parse("23:50", TIME_FORMATTER),
            "S7",
            1,
            13100);

    public static final Ticket[] TICKETS = new Ticket[]{TICKET_1, TICKET_2};

}
