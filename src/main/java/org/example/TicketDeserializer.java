package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TicketDeserializer extends StdDeserializer<Ticket> {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");

    public TicketDeserializer() {
        this(null);
    }

    public TicketDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Ticket deserialize(JsonParser parser, DeserializationContext ctx)
            throws IOException {

        JsonNode node = parser.getCodec().readTree(parser);
        String origin = node.get("origin").asText();
        String originName = node.get("origin_name").asText();
        String destination = node.get("destination").asText();
        String destinationName = node.get("destination_name").asText();
        String departureDate = node.get("departure_date").asText();
        String departureTime = node.get("departure_time").asText();
        String arrivalDate = node.get("arrival_date").asText();
        String arrivalTime = node.get("arrival_time").asText();
        String carrier = node.get("carrier").asText();
        Integer stops = (Integer) node.get("stops").numberValue();
        Integer price = (Integer) node.get("price").numberValue();

        LocalDate localDateDeparture = LocalDate.parse(departureDate, DATE_FORMATTER);
        LocalTime localTimeDeparture = LocalTime.parse(departureTime, TIME_FORMATTER);
        LocalDate localDateArrival = LocalDate.parse(arrivalDate, DATE_FORMATTER);
        LocalTime localTimeArrival = LocalTime.parse(arrivalTime, TIME_FORMATTER);

        return new Ticket(origin, originName, destination, destinationName, localDateDeparture, localTimeDeparture, localDateArrival, localTimeArrival, carrier, stops, price);
    }
}
