package com.example.java8.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeLegacySupport {

    public static void main(String[] args) {
        legacySupport();
    }

    private static void legacySupport() {
        Instant instant = new Date().toInstant();
        LocalDateTime now = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("Date from legacy API = " + now);

        Date now2 = Date.from(Instant.now());
        System.out.println("Date from new API = " + now2);
    }
}
