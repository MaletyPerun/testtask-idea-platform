package org.example;

import lombok.experimental.UtilityClass;

import java.time.Duration;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@UtilityClass
public class Calculator {

    public static String calculateAverageTime(Ticket[] tickets) {

        List<Integer> minutes = calculateAllMinutes(tickets);

        OptionalDouble res = minutes.stream()
                .mapToInt(s -> s)
                .average();

        if (!res.isPresent()) {
            return "Nothing!";
        }

        return getTime(res.getAsDouble());
    }

    public static String calculatePercentOfTime(Ticket[] tickets) {

        List<Integer> minutes = calculateAllMinutes(tickets);

        OptionalInt max = minutes.stream()
                .mapToInt(s -> s)
                .max();

        if (!max.isPresent()) {
            return "Nothing!";
        }

        return getTime(max.getAsInt());
    }

    public static List<Integer> calculateAllMinutes(Ticket[] tickets) {

        return Arrays.stream(tickets)
                .map(Calculator::calculateMinutes)
                .collect(Collectors.toList());
    }

    private static Integer calculateMinutes(Ticket ticket) {
        ZonedDateTime departure = ZonedDateTime.of(ticket.getDepartureDate(), ticket.getDepartureTime(), ZoneOffset.of("+10"));
        ZonedDateTime arrival = ZonedDateTime.of(ticket.getArrivalDate(), ticket.getArrivalTime(), ZoneOffset.of("+02"));
        return (int) Duration.between(departure, arrival).toMinutes();
    }

    public static String getTime(int minutes) {
        return String.format("%d hours %d min", minutes / 60, minutes % 60);
    }

    public static String getTime(double minutes) {
        int intMin = (int) Math.round(minutes);
        return String.format("%d hours %d min", intMin / 60, intMin % 60);
    }
}
