package org.example.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;

import static org.example.util.Formatter.DATE_FORMATTER;

public class DataDeserializer extends StdDeserializer<LocalDate> {

    public DataDeserializer() {
        this(null);
    }

    public DataDeserializer(Class t) {
        super(t);
    }

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext ctx)
            throws IOException {

        String date = parser.getText();
        return LocalDate.parse(date, DATE_FORMATTER);
    }
}
