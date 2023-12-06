package com.example.test11.learn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class DateUtil {

    /**
     * PATTERN_0
     */
    public static final String PATTERN_0 = "yyyy-MM-dd HH:mm:ss";

    /**
     * PATTERN_1
     */
    public static final String PATTERN_1 = "yyyy-MM-dd HH:mm:ssSSS";

    /**
     * PATTERN_2
     */
    public static final String PATTERN_2 = "yyyy-MM-dd HH:mm:ssSSSSSS";

    /**
     * PATTERN_3
     */
    public static final String PATTERN_3 = "yyyy/MM/dd HH:mm:ss";

    /**
     * PATTERN_4
     */
    public static final String PATTERN_4 = "yyyy/MM/dd HH:mm:ssSSS";

    /**
     * PATTERN_5
     */
    public static final String PATTERN_5 = "yyyy/MM/dd HH:mm:ssSSSSSS";

    /**
     * PATTERN_6
     */
    public static final String PATTERN_6 = "yyyyMMddHHmmss";

    /**
     * PATTERN_7
     */
    public static final String PATTERN_7 = "yyyyMMddHHmmssSSS";

    /**
     * PATTERN_8
     */
    public static final String PATTERN_8 = "yyyyMMddHHmmssSSSSSS";

    /**
     * PATTERN_9
     */
    public static final String PATTERN_9 = "yyyyMMddHHmm";

    /**
     * PATTERN_10
     */
    public static final String PATTERN_10 = "yyyy年M月dd日";

    /**
     * yyyy-MM-dd
     */
    public static final String PATTERN_11 = "yyyy-MM-dd";

    /**
     * MM月dd日
     */
    public static final String MONTH_DAY = "MM月dd日";


    /**
     * HH:mm
     */
    public static final String PATTERN_12 = "HHmm";

    /**
     * yyyyMMdd
     */
    public static final String PATTERN_13 = "yyyyMMdd";


    /**
     * yyyy/MM/dd
     */
    public static final String PATTERN_14 = "yyyy/MM/dd";

    public static final String PATTERN_15 = "yyyy-MM";
    public static final String PATTERN_16 = "MM/dd";
    public static final String PATTERN_17 = "yyyy";
    public static final String PATTERN_18 = "MM/dd HH:mm:ss";
    /**
     * 年月日 时:分
     */
    public static final String PATTERN_19 = "yyyy-MM-dd HH:mm";
    /**
     * yyyyMM
     */
    public static final String PATTERN_20 = "yyyyMM";

    /**
     * LocalDateTime转换为java.lang.String
     *
     * @param localDateTime LocalDateTime时间
     * @return java.lang.String
     */
    public static String localDateTime2Str(LocalDateTime localDateTime) {
        return localDateTime2Str(localDateTime, PATTERN_0);
    }

    /**
     * LocalDateTime转换为java.lang.String
     *
     * @param localDateTime LocalDateTime时间
     * @param pattern       模式
     * @return java.lang.String
     */
    public static String localDateTime2Str(LocalDateTime localDateTime, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(localDateTime);
    }

    public static LocalDateTime str2LocalDateTime(String date) {
        return str2LocalDateTime(date, PATTERN_0);
    }

    public static LocalDateTime str2LocalDateTime(String date, String pattern) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate str2LocalDate(String date) {
        return str2LocalDate(date, PATTERN_11);
    }

    public static LocalDate str2LocalDate(String date, String pattern) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }


    /**
     * date转换为java.lang.String
     *
     * @param date java.util.Date
     * @return java.lang.String
     */
    public static String dateTime2Str(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime2Str(localDateTime);
    }

    /**
     * date转换为java.lang.String
     *
     * @param date    java.util.Date
     * @param pattern 格式
     * @return java.lang.String
     */
    public static String dateTime2Str(Date date, String pattern) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime2Str(localDateTime, pattern);
    }

    public static long date2Long(String date) {
        return date2Long(date, PATTERN_11);
    }

    public static long date2Long(String date, String pattern) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern(pattern)
                .toFormatter()
                .withZone(ZoneId.systemDefault());
        LocalDate ld = LocalDate.parse(date, formatter);

        LocalDateTime ldt = LocalDateTime.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth(), 0, 0, 0);


        ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());

        return zdt.toInstant().toEpochMilli();
    }

    public static long dateTime2Long(String date) {
        return dateTime2Long(date, PATTERN_0);
    }

    public static long dateTime2Long(String date, String pattern) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern(pattern)
                .toFormatter()
                .withZone(ZoneId.systemDefault());
        LocalDateTime ldt = LocalDateTime.parse(date, formatter);

        ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());

        return zdt.toInstant().toEpochMilli();
    }

    public static String long2Str(long milli) {
        return long2Str(milli, PATTERN_0);
    }

    public static String long2Str(long milli, String pattern) {
        LocalDateTime localDateTime = Instant.ofEpochMilli(milli).atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime2Str(localDateTime, pattern);
    }

    public static Date str2Date(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String localDate2Str(LocalDate date, String pattern) {
        return date.format( DateTimeFormatter.ofPattern(pattern));
    }
}
