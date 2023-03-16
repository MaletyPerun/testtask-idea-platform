package org.example;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

@UtilityClass
public class Calculator {
    public static LocalTime calculateAverageTime(Ticket[] tickets) {

        List<Integer> minutes = new ArrayList<>();

        for (Ticket ticket : tickets) {
            LocalDateTime departure = LocalDateTime.of(ticket.getDepartureDate(), ticket.getDepartureTime());
            LocalDateTime arrival = LocalDateTime.of(ticket.getArrivalDate(), ticket.getArrivalTime());

            System.out.println(ChronoUnit.MINUTES.between(departure, arrival));

            minutes.add((int) ChronoUnit.MINUTES.between(departure, arrival));

            int time = (int) ChronoUnit.MINUTES.between(departure, arrival);
        }

        OptionalDouble aver = minutes.stream() //
                .mapToInt(i -> i) //
                .average();

        OptionalInt max = minutes.stream() //
                .mapToInt(i -> i) //
                .max();

        int avr = (int) aver.getAsDouble();
        double percent = max.getAsInt() * 0.9;
        System.out.println(percent);
        for (Ticket ticket : tickets) {

        }
        // TODO: 16.03.2023 in another method to convert into LocalTime
        int hours = avr / 60;
        int min = avr % 60;
//        LocalTime ly = LocalTime.of(hours, min);
        System.out.println("******");
//        System.out.println(ly);
//        System.out.println(avr);
        System.out.println(getTime(avr));
        System.out.println(getTime(percent));
//        LocalDate date = LocalDate.now();
//        LocalTime time = LocalTime.now();
//        LocalTime timeEnd = time.plus(2, ChronoUnit.HOURS);
//
//        long l = (time.getLong(ChronoField.MINUTE_OF_DAY) - timeEnd.getLong(ChronoField.MINUTE_OF_DAY)) / 2;
//
//        LocalDateTime fr = LocalDateTime.
//
//                LocalTime averange = LocalTime.of();
//
//        LocalDateTime dateTime = LocalDateTime.of(date, time);

//        ChronoUnit.HOURS.
        return getTime(avr);
    }

    public static LocalTime calculatePercentOfTime(Ticket[] tickets){
        List<Integer> minutes = new ArrayList<>();

        for (Ticket ticket : tickets) {
            LocalDateTime departure = LocalDateTime.of(ticket.getDepartureDate(), ticket.getDepartureTime());
            LocalDateTime arrival = LocalDateTime.of(ticket.getArrivalDate(), ticket.getArrivalTime());

            System.out.println(ChronoUnit.MINUTES.between(departure, arrival));

            minutes.add((int) ChronoUnit.MINUTES.between(departure, arrival));

            int time = (int) ChronoUnit.MINUTES.between(departure, arrival);
        }
        OptionalInt max = minutes.stream() //
                .mapToInt(i -> i) //
                .max();
        double percent = max.getAsInt() * 0.9;
        return getTime(percent);
    }

    public static LocalTime getTime(int minutes) {
        return LocalTime.of(minutes / 60, minutes % 60);
    }

    public static LocalTime getTime(double minutes) {
        return LocalTime.of((int) minutes / 60, (int) minutes % 60);
    }
}
