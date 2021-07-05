package ru.job4j.grabber.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class SqlRuDateTimeParser implements DateTimeParser {
    private Integer year;
    private Month month;
    private Integer day;
    private Integer hours;
    private Integer minutes;
    private static final Map<String, Integer> shortMonths = new HashMap<>();
    {
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
    }

    public void setDate(LocalDate date, String [] timeArr) {
        year = date.getYear();
        month = date.getMonth();
        day = date.getDayOfMonth();
        hours = Integer.parseInt(timeArr[0]);
        minutes = Integer.parseInt(timeArr[1]);
    };

    public void seNormalDte(String [] dateArr) {
        String[] timeArr = dateArr[3].split(":");
        year = Integer.parseInt(dateArr[2].substring(0, dateArr[2].length() - 1));
        day = Integer.parseInt(dateArr[0]);
        hours = Integer.parseInt(timeArr[0]);
        minutes = Integer.parseInt(timeArr[1]);
        month = Month.of(shortMonths.get(dateArr[1]));
    }

    @Override
    public LocalDateTime parse(String parse) throws ParseException {
        String [] dateArr = parse.split(" ");
        if (dateArr[0].equals("сегодня,") || dateArr[0].equals("вчера,")) {
            String[] timeArr = dateArr[1].split(":");
            if (dateArr[0].equals("сегодня")) {
                setDate(LocalDate.now(), timeArr);
            } else {
                setDate(LocalDate.now().minusDays(1), timeArr);
            }
        } else {
            seNormalDte(dateArr);
        }
        LocalDateTime localDateTime = LocalDateTime
                .of(year, month, day, hours, minutes);
        System.out.println(localDateTime);

        return localDateTime;
    }

    public static void main(String[] args) throws ParseException {
        SqlRuDateTimeParser sqlRuDateTimeParser = new SqlRuDateTimeParser();
        sqlRuDateTimeParser.parse("вчера, 17:16");
    }
}