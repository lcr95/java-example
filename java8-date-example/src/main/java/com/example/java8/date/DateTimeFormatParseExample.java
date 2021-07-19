package com.example.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatParseExample {
    public static void main(String[] args) {
        formatExample();
        System.out.println();
        parseExample();
    }

    private static void formatExample() {
        System.out.println("Local Date");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));

        System.out.println("\nLocal Time");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("hh:mm")));
        System.out.println(localTime.format(DateTimeFormatter.ISO_TIME));


        System.out.println("\nLocal Date Time");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }

    private static void parseExample(){

        LocalDate localDate = LocalDate.parse("2020/01/19", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(localDate);

        LocalTime localTime = LocalTime.parse("08-55", DateTimeFormatter.ofPattern("HH-mm"));
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.parse("27::05::2020 21::39::48",
                DateTimeFormatter.ofPattern("d::MM::uuuu HH::mm::ss"));
        System.out.println(localDateTime);
    }


}
