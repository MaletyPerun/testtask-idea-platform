package org.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonDeserialize(using = DateDesrializator.class)
public class Ticket {
    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    //    @JsonFormat(pattern = "dd.MM.yyyy")
//    @JsonDeserialize(as = LocalDate.class)
//    @JsonDeserialize(using = DateDesrializator.class)
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @DateTimeFormat(iso = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
//    @JsonFormat(pattern = "dd.MM.yyyy")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
//    @JsonFormat(pattern = "dd.MM.yy")
//    @JsonDeserialize(using = DateDesrializator.class)
    private LocalDate departure_date;
    //    @JsonFormat(pattern = "dd/MM/yyyy")
//    @JsonDeserialize(using = DateDesrializator.class)
    private LocalTime departure_time;
    //    @JsonFormat(pattern = "dd/MM/yyyy")
//    @JsonFormat(pattern = "dd.MM.yyyy")
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonDeserialize(using = DateDesrializator.class)
    private LocalDate arrival_date;
    //    @JsonFormat(pattern = "dd/MM/yyyy")
//    @JsonDeserialize(using = DateDesrializator.class)
    private LocalTime arrival_time;
    private String carrier;
    private int stops;
    private int price;
}
