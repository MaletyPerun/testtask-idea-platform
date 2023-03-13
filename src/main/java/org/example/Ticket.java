package org.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ticket {
    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate departure_date;
//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalTime departure_time;
//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate arrival_date;
//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalTime arrival_time;
    private String carrier;
    private int stops;
    private int price;
}
