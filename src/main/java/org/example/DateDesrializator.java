package org.example;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateDesrializator extends StdDeserializer<Ticket> {
//    private static DateTimeFormatter df
//            = DateTimeFormatter.ofPattern("dd.MM.yy", Locale.getDefault());

//    private static DateTimeFormatter tf
//            = DateTimeFormatter.ofPattern("hh:mm", Locale.getDefault());

    DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd.MM.yy");
    DateTimeFormatter formatterT = DateTimeFormatter.ofPattern("hh:mm a");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");



    public DateDesrializator() {
        this(null);
    }

    public DateDesrializator(Class<?> vc) {
        super(vc);
    }

    @Override
    public Ticket deserialize(JsonParser parser, DeserializationContext ctx)
            throws IOException, JacksonException {

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
        Integer stops = (Integer) ((IntNode) node.get("stops")).numberValue();
        Integer price = (Integer) ((IntNode) node.get("price")).numberValue();

        String departure = departure_date + " " + departure_time;
        String arrival = arrival_date + " " + arrival_time;

        LocalDateTime dtfd = LocalDateTime.parse(departure, formatter);
        LocalDateTime dtfa = LocalDateTime.parse(arrival, formatter);

//        LocalDate dfd = LocalDate.parse(departure_date, formatterD);
//        LocalTime tfd = LocalTime.parse(departure_time, formatterT);
//        LocalDate dfa = LocalDate.parse(arrival_date, formatterD);
//        LocalTime tfa = LocalTime.parse(arrival_time, formatterT);

        LocalDate dep_day = dtfd.toLocalDate();
        LocalTime dep_time = dtfd.toLocalTime();
        LocalDate arr_day = dtfa.toLocalDate();
        LocalTime arr_time = dtfa.toLocalTime();



//        Integer id = (Integer) ((IntNode) node.get("id")).numberValue();
//        String message = node.get("message").asText();
//        String timestamp = node.get("timestamp").asText();




        return new Ticket(origin, origin_name, destination, destination_name,
                dep_day,
                dep_time,
                arr_day,
                arr_time,
                carrier, stops, price);

//        return new Record(id.longValue(), message, ZonedDateTime.parse(timestamp, dtf), status);
    }
}
