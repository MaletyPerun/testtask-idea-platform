package org.example.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalTime;

import static org.example.util.Formatter.TIME_FORMATTER;

public class TimeDeserializer extends StdDeserializer<LocalTime> {

    public TimeDeserializer() {
        this(null);
    }

    public TimeDeserializer(Class t) {
        super(t);
    }

    @Override
    public LocalTime deserialize(JsonParser parser, DeserializationContext ctx)
            throws IOException {

        String time = parser.getText();
        return LocalTime.parse(time, TIME_FORMATTER);
    }
}
