package com.example.java8.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;

public class DateTimeCreationExample {

    public static void main(String[] args) {
//        localDateExample();
//        localTimeExample();
//        localDateTimeExample();
//        offsetDateTimeExample();
        instantExample();
    }

    private static void localDateExample() {
        LocalDate now = LocalDate.now();
        System.out.println("Current Date = " + now);

        LocalDate secondDayInMarch2020 = LocalDate.parse("2020-03-02");
        System.out.println("second day in march 2020");

        LocalDate thirdDayInMarch2020 = LocalDate.of(2020, 3, 3);
        System.out.println("third day in march 2020 = " + thirdDayInMarch2020);

        LocalDate hundredDayIn2020 = LocalDate.ofYearDay(2020, 100);
        System.out.println("100th day in 2020 = " + hundredDayIn2020);

        LocalDate klDateNow = LocalDate.now(ZoneId.of("Asia/Kuala_Lumpur"));
        System.out.println("Current Date in Kuala Lumpur = " + klDateNow);

        LocalDate tokyoDateNow = LocalDate.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Current Date in Tokyo = " + tokyoDateNow);

        LocalDate chicagoDateNow = LocalDate.now(ZoneId.of("America/Chicago"));
        System.out.println("Current Date in Chicago = " + chicagoDateNow);
    }

    private static void localTimeExample() {
        LocalTime now = LocalTime.now();
        System.out.println("Current Time = " + now);

        LocalTime customTime = LocalTime.of(5, 30, 0, 0);
        System.out.println("My custom time = " + customTime);

        LocalTime customTime2 = LocalTime.parse("05:45:00.000");
        System.out.println("My custom time2 = " + customTime2);

        LocalTime klTimeNow = LocalTime.now(ZoneId.of("Asia/Kuala_Lumpur"));
        System.out.println("Current Time in Kuala Lumpur = " + klTimeNow);

        LocalTime tokyoTimeNow = LocalTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Current Time in Tokyo = " + tokyoTimeNow);

        LocalTime chicagoTimeNow = LocalTime.now(ZoneId.of("America/Chicago"));
        System.out.println("Current Time in Chicago = " + chicagoTimeNow);

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("available zone id = \n" + availableZoneIds);

    }

    private static void localDateTimeExample() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date Time = " + now);

        LocalDateTime customDateTime = LocalDateTime.of(2020, 3, 19, 5, 30, 0);
        System.out.println("My custom Date Time = " + customDateTime);

        LocalDateTime customDateTime2 = LocalDateTime.parse("2020-03-19T06:30:00");
        System.out.println("My custom Date Time = " + customDateTime2);

        LocalDateTime klDateTimeNow = LocalDateTime.now(ZoneId.of("Asia/Kuala_Lumpur"));
        System.out.println("Current Date Time in Kuala Lumpur = " + klDateTimeNow);

        LocalDateTime tokyoDateTimeNow = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Current Date Time in Tokyo = " + tokyoDateTimeNow);

        LocalDateTime chicagoDateTimeNow = LocalDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println("Current Date Time in Chicago = " + chicagoDateTimeNow);
    }

    private static void offsetDateTimeExample() {
        OffsetDateTime now = OffsetDateTime.now();
        System.out.println("Current Offset Date Time = " + now);

        OffsetDateTime customDateTime = OffsetDateTime.of(2020, 3, 19, 5, 30, 0, 0, ZoneOffset.of("+08:00"));
        System.out.println("My custom Offset Date Time = " + customDateTime);

        OffsetDateTime customDateTime2 = OffsetDateTime.parse("2020-03-19T06:30:00+08:00");
        System.out.println("My custom Offset Date Time = " + customDateTime2);

        OffsetDateTime klDateTimeNow = OffsetDateTime.now(ZoneId.of("Asia/Kuala_Lumpur"));
        System.out.println("Current Offset Date Time in Kuala Lumpur = " + klDateTimeNow);

        OffsetDateTime tokyoDateTimeNow = OffsetDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Current Offset Date Time in Tokyo = " + tokyoDateTimeNow);

        OffsetDateTime chicagoDateTimeNow = OffsetDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println("Current Offset Date Time in Chicago = " + chicagoDateTimeNow);
    }

    private static void instantExample() {
        Instant now = Instant.now();
        System.out.println("Current timestamp = " + now);

        Instant currentInstant = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println("Current timestamp2 " + currentInstant);

    }
}
