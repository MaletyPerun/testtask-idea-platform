package org.example.service;

import org.example.model.Ticket;

import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static org.example.util.OriginZone.ORIGIN_ZONE;

public class Calculator {

    public String calculateAverageTime(Ticket[] tickets) {

        List<Integer> minutes = calculateAllMinutes(tickets);

        OptionalDouble res = minutes.stream()
                .mapToInt(s -> s)
                .average();

        if (res.isEmpty()) {
            return "Nothing!";
        }

        return getTime(res.getAsDouble());
    }

    public String calculatePercentOfTime(Ticket[] tickets) {

        List<Integer> minutes = calculateAllMinutes(tickets);

        OptionalInt max = minutes.stream()
                .mapToInt(s -> s)
                .max();

        if (max.isEmpty()) {
            return "Nothing!";
        }

        return getTime(max.getAsInt());
    }

    public List<Integer> calculateAllMinutes(Ticket[] tickets) {

        return Arrays.stream(tickets)
                .map(Calculator::calculateMinutes)
                .collect(Collectors.toList());
    }

    private static Integer calculateMinutes(Ticket ticket) {
        Instant departure = ZonedDateTime.of(
                ticket.getDepartureDate(),
                ticket.getDepartureTime(),
                ZoneOffset.of(ORIGIN_ZONE.get(ticket.getOrigin()))).toInstant();
        Instant arrival = ZonedDateTime.of(
                ticket.getArrivalDate(),
                ticket.getArrivalTime(),
                ZoneOffset.of(ORIGIN_ZONE.get(ticket.getDestination()))).toInstant();
        return (int) Duration.between(departure, arrival).toMinutes();
    }

    public String getTime(int minutes) {
        return String.format("%d hours %d min", minutes / 60, minutes % 60);
    }

    public String getTime(double minutes) {
        int intMin = (int) Math.round(minutes);
        return String.format("%d hours %d min", intMin / 60, intMin % 60);
    }
}
