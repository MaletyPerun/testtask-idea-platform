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

    DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd.MM.yy");
    DateTimeFormatter formatterT = DateTimeFormatter.ofPattern("H:mm");

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
        String origin_name = node.get("origin_name").asText();
        String destination = node.get("destination").asText();
        String destination_name = node.get("destination_name").asText();
        String departure_date = node.get("departure_date").asText();
        String departure_time = node.get("departure_time").asText();
        String arrival_date = node.get("arrival_date").asText();
        String arrival_time = node.get("arrival_time").asText();
        String carrier = node.get("carrier").asText();
        Integer stops = (Integer) node.get("stops").numberValue();
        Integer price = (Integer) node.get("price").numberValue();

        LocalDate dfd = LocalDate.parse(departure_date, formatterD);
        LocalTime tfd = LocalTime.parse(departure_time, formatterT);
        LocalDate dfa = LocalDate.parse(arrival_date, formatterD);
        LocalTime tfa = LocalTime.parse(arrival_time, formatterT);

        return new Ticket(origin, origin_name, destination, destination_name, dfd, tfd, dfa, tfa, carrier, stops, price);
    }
}
