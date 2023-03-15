package org.example;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonDeserialize(using = TicketDeserializer.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class Ticket {
    private String origin;
    private String originName;
    private String destination;
    private String destinationName;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private String carrier;
    private int stops;
    private int price;
}
