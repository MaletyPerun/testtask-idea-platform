package org.example.util;

import lombok.experimental.UtilityClass;

import java.time.format.DateTimeFormatter;

@UtilityClass
public class Formatter {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");
}
