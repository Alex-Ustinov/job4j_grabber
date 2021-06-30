package ru.job4j.grabber.utils;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class SqlRuDateTimeParser implements DateTimeParser {
    @Override
    public LocalDateTime parse(String parse) throws ParseException {
        String [] dateArr = parse.split(" ");
        String [] timeArr = dateArr[3].split(":");
        String year = dateArr[2].substring(0, dateArr[2].length() - 1);

        HashMap<String, Integer> shortMonths = new HashMap<>();
        shortMonths.put("янв", 1);
        shortMonths.put("фев", 2);
        shortMonths.put("мар", 3);
        shortMonths.put("апр", 4);
        shortMonths.put("май", 5);
        shortMonths.put("июн", 6);
        shortMonths.put("июл", 7);
        shortMonths.put("авг", 8);
        shortMonths.put("сен", 9);
        shortMonths.put("окт", 10);
        shortMonths.put("ноя", 11);
        shortMonths.put("дек", 12);
        Integer month = shortMonths.get(dateArr[1]);

        LocalDateTime localDateTime = LocalDateTime
                .of(Integer.parseInt(year),
                        Month.of(month),
                        Integer.parseInt(dateArr[0]),
                        Integer.parseInt(timeArr[0]),
                        Integer.parseInt(timeArr[1])
                );
        System.out.println(localDateTime);

        return localDateTime;
    }

    public static void main(String[] args) throws ParseException {
        SqlRuDateTimeParser sqlRuDateTimeParser = new SqlRuDateTimeParser();
        sqlRuDateTimeParser.parse("23 апр 21, 17:16");
    }
}