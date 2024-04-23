package com.ohgiraffers.section06.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class Application2 {
    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now();

        System.out.println("LocalTime: " + localTime);
        System.out.println("LocalTime 시간: " + localTime.getHour());
        System.out.println("LocalTime 분: " + localTime.getMinute());
        System.out.println("LocalTime 초: " + localTime.getSecond());
        System.out.println("LocalTime 나노 초: " + localTime.getNano());


        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: " + localDate);
        System.out.println("LocalDate 년: " + localDate.getYear());
        System.out.println("LocalDate 월: " + localDate.getMonth());
        System.out.println("LocalDate 월 숫자: " + localDate.getMonthValue());
        System.out.println("LocalDate 월 중 몇 번째 일: " + localDate.getDayOfMonth());
        System.out.println("LocalDate 1년 중 몇 번째 일: " + localDate.getDayOfYear());
        System.out.println("LocalDate 한 주의 몇 번째 요일: " + localDate.getDayOfWeek());


        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonDateTime: " + zonedDateTime);
        System.out.println("zone 정보: " + zonedDateTime.getZone());
        System.out.println("시차: " + zonedDateTime.getOffset());
    }
}
