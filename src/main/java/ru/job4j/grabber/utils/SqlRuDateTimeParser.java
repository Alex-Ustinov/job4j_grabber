package ru.job4j.grabber.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SqlRuDateTimeParser implements DateTimeParser {
    @Override
    public LocalDateTime parse(String parse) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yy, HH:mm");
        return LocalDateTime.parse(dateFormat.format(parse));
    }
}