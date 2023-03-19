package org.example.util;

import lombok.experimental.UtilityClass;

import java.time.format.DateTimeFormatter;
import java.util.Map;

@UtilityClass
public class Formatter {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");

    public static final Map<String, String> ORIGIN_TIME_ZONE = Map.of(
            "VVO", "+10",
            "TLV", "+02");
}
