package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.deser.DataDeserializer;
import org.example.deser.TimeDeserializer;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class Ticket {
    private String origin;
    private String originName;
    private String destination;
    private String destinationName;
    @JsonDeserialize(using = DataDeserializer.class)
    private LocalDate departureDate;
    @JsonDeserialize(using = TimeDeserializer.class)
    private LocalTime departureTime;
    @JsonDeserialize(using = DataDeserializer.class)
    private LocalDate arrivalDate;
    @JsonDeserialize(using = TimeDeserializer.class)
    private LocalTime arrivalTime;
    private String carrier;
    private int stops;
    private int price;
}
