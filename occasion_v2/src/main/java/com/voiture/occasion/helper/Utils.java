package com.voiture.occasion.helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static LocalDateTime stringToDateTime(String datetime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(datetime, dtf);
    }

    public static LocalDate stringToDate(String date) {
        return LocalDate.parse(date);
    }
}
