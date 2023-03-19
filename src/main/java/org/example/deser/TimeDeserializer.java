package org.example.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.example.util.Formatter.TIME_FORMATTER;

public class TimeDeserializer extends StdDeserializer<LocalTime> {

    public TimeDeserializer() {
        this(null);
    }

    public TimeDeserializer(Class t) {
        super(t);
    }

//    @Override
//    public void serialize (Date value, JsonGenerator gen, SerializerProvider arg2)
//            throws IOException, JsonProcessingException {
//        gen.writeString(DATE_FORMATTER.format(value));
//    }

//    @Override
//    public Ticket deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
//        return null;
//    }

    @Override
    public LocalTime deserialize(JsonParser parser, DeserializationContext ctx)
            throws IOException {

//        JsonNode node = parser.getCodec().readTree(parser);
        String time = parser.getText();
//        String departureDate = node.get("departure_date").asText();
//        String arrivalDate = node.get("arrival_date").asText();

        return LocalTime.parse(time, TIME_FORMATTER);
//        LocalDate localDateArrival = LocalDate.parse(arrivalDate, DATE_FORMATTER);

    }
}
