package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.example.TicketDeserializer.DATE_FORMATTER;
import static org.example.TicketDeserializer.TIME_FORMATTER;

public class TestData {


    public static final String JSON_STRING = "{\n" +
            "  \"tickets\": [{\n" +
            "    \"origin\": \"VVO\",\n" +
            "    \"origin_name\": \"Владивосток\",\n" +
            "    \"destination\": \"TLV\",\n" +
            "    \"destination_name\": \"Тель-Авив\",\n" +
            "    \"departure_date\": \"12.05.18\",\n" +
            "    \"departure_time\": \"16:20\",\n" +
            "    \"arrival_date\": \"12.05.18\",\n" +
            "    \"arrival_time\": \"22:10\",\n" +
            "    \"carrier\": \"TK\",\n" +
            "    \"stops\": 3,\n" +
            "    \"price\": 12400\n" +
            "  }, {\n" +
            "    \"origin\": \"VVO\",\n" +
            "    \"origin_name\": \"Владивосток\",\n" +
            "    \"destination\": \"TLV\",\n" +
            "    \"destination_name\": \"Тель-Авив\",\n" +
            "    \"departure_date\": \"12.05.18\",\n" +
            "    \"departure_time\": \"17:20\",\n" +
            "    \"arrival_date\": \"12.05.18\",\n" +
            "    \"arrival_time\": \"23:50\",\n" +
            "    \"carrier\": \"S7\",\n" +
            "    \"stops\": 1,\n" +
            "    \"price\": 13100\n" +
            "  }]\n" +
            "}";

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
