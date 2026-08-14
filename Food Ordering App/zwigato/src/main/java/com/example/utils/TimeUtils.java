package com.example.utils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    private TimeUtils() {
        // Private constructor to prevent instantiation
    }
    public static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy"));
    }
}