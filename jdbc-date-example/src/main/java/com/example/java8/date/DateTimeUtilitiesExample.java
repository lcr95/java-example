package com.example.java8.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilitiesExample {

    public static void main(String[] args) {
        dateUtilityMethods();
        periodUtilityClass();
        timeUtilityMethods();
        durationUtilityClass();
    }

    public static void dateUtilityMethods() {

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("now = " + now1);

        LocalDateTime truncatedToDay = now1.truncatedTo(ChronoUnit.DAYS);
        System.out.println("Truncate until days = " + truncatedToDay);

        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);

        LocalDate tomorrow = now.plusDays(1);
        System.out.println("Tomorrow = " + tomorrow);

        LocalDate twoWeekAfter = now.plusWeeks(2);
        System.out.println("2 week after today = " + tomorrow);

        LocalDate nextMonth = now.plus(1, ChronoUnit.MONTHS);
        System.out.println("1 month after today = " + tomorrow);

        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println("Day of week = " + dayOfWeek.name());

        int dayOfYear = now.getDayOfYear();
        System.out.println("Day of year = " + dayOfYear);

        boolean isLeapYear = now.isLeapYear();
        System.out.println("Is Leap Year = " + isLeapYear);

        boolean notBefore = now.isBefore(tomorrow);
        System.out.println(now + "is before " + tomorrow + " = " + notBefore);

        boolean isAfter = nextMonth.isAfter(now);
        System.out.println(nextMonth + "is after " + now + " = " + isAfter);

    }

    private static void timeUtilityMethods() {
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("now = " + now1);

        LocalDateTime oneHourBefore = now1.plusHours(1);
        System.out.println("one hour before" + oneHourBefore);

        LocalDateTime twoDaysLater = now1.plusDays(2);
        System.out.println("two days later = " + twoDaysLater);

        LocalDateTime truncatedToHours = now1.truncatedTo(ChronoUnit.HOURS);
        System.out.println("Truncate until hours = " + truncatedToHours);

        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);

        LocalTime twoHoursLater = now.plusHours(2);
        System.out.println("2 hours later = " + twoHoursLater);

        LocalTime thirtyBefore = now.minusMinutes(30);
        System.out.println("30 minutes before = " + thirtyBefore);

        LocalTime fourHoursBefore = now.minus(4, ChronoUnit.HOURS);
        System.out.println("4 hours before = " + fourHoursBefore);

        boolean isBefore = now.isBefore(twoHoursLater);
        System.out.println(now + " is before " + twoHoursLater + " = " + isBefore);

        boolean isAfter = twoHoursLater.isAfter(now);
        System.out.println(twoHoursLater + " is after " + now + " = " + isAfter);

        LocalTime maxTime = LocalTime.MAX;
        System.out.println("Max Time = " + maxTime);

        LocalTime minTime = LocalTime.MIN;
        System.out.println("Min Time = " + minTime);

    }

    private static void periodUtilityClass() {
        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);

        Period fiveDay = Period.ofDays(5);
        LocalDate fiveDaysLater = now.plus(fiveDay);
        System.out.println("5 days later = " + fiveDaysLater);

        Period twoMonth = Period.ofMonths(2);
        LocalDate twoMonthBefore = now.minus(twoMonth);
        System.out.println("2 months before = " + twoMonthBefore);

        Period oneYear = Period.ofYears(1);
        LocalDate oneYearAfter = now.plus(oneYear);
        System.out.println("1 year after = " + oneYearAfter);

        int daysBetween = Period.between(now, fiveDaysLater).getDays();
        System.out.println("Days difference between " + now + " and " + fiveDaysLater + " = " + daysBetween);

        int daysDiff1 = Period.between(now, oneYearAfter).getDays();
        System.out.println("Days difference between " + now + " and " + oneYearAfter + " = " + daysDiff1);

        long daysDiff2 = ChronoUnit.DAYS.between(now, oneYearAfter);
        System.out.println("Days difference between " + now + " and " + oneYearAfter + " = " + daysDiff2);

    }

    private static void durationUtilityClass() {
        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);

        Duration twoHours = Duration.ofHours(2);
        LocalTime twoHoursLater = now.plus(twoHours);
        System.out.println("2 hours later = " + twoHoursLater);

        Duration fortyMinutes = Duration.ofMinutes(40);
        LocalTime fortyMinutesBefore = now.minus(fortyMinutes);
        System.out.println("40 minutes before = " + fortyMinutesBefore);

        Duration thirtySeconds = Duration.ofSeconds(30);
        LocalTime thirtySecondsLater = now.plus(thirtySeconds);
        System.out.println("30 seconds later = " + thirtySecondsLater);

        long hoursDiff = Duration.between(now, twoHoursLater).toHours();
        System.out.println("Hours difference between " + now + " and " + twoHoursLater + " = " + hoursDiff);

        long secondsDiff1 = Duration.between(now, fortyMinutesBefore).getSeconds();
        System.out.println("Second difference between " + now + " and " + fortyMinutesBefore + " = " + secondsDiff1);

    }

}
