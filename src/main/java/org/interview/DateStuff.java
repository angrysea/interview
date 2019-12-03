package org.interview;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.Function;

public class DateStuff {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private static final Function<Date, String> DATE_CONVERTER = date -> {
        Instant instant = date.toInstant();
        LocalDateTime ldt = instant
                .atZone(ZoneId.of("UTC"))
                .toLocalDateTime();
        return ldt.format(DATE_TIME_FORMATTER);
    };

    private static final Function<String, Date> STRING_TO_DATE = string -> {
        LocalDateTime ldt = LocalDateTime.parse(string, DATE_TIME_FORMATTER);
        Instant instant = ldt.atZone(ZoneId.of("UTC")).toInstant();
        return Date.from(instant);
    };

    private void test(final String testDate) {
        try {
            System.out.println(DATE_CONVERTER.apply(new Date()));
            Date value = STRING_TO_DATE.apply(testDate);
            System.out.println(DATE_CONVERTER.apply(value));
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static void main(String[] args) {
        DateStuff stuff = new DateStuff();
        stuff.test("2019-01-01 01:30");
    }
}
