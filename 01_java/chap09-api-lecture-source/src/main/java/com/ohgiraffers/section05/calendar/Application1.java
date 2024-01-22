package com.ohgiraffers.section05.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. java.util.Date 클래스 사용법을 이해하고 사용할 수 있다. */

        Date today = new Date();
        System.out.println("today = " + today);
        System.out.println("long type = " + today.getTime());
        System.out.println("Date of long type = " + new Date(today.getTime()));
        System.out.println("기준시간 1970년 9시 0분 0초 = " + new Date(0l));

        /* 설명. 우리가 원하는 형태로 출력(feat. SipleDateFormat) */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh:mm:ss");
        String todayFormat = sdf.format(today);
        System.out.println("todayFormat = "+ todayFormat);


        /* 설명. java.util.Date -> java.sql.Date */
        java.sql.Date sqlDate = new java.sql.Date(today.getTime());     // java.util.Date long변환
//        java.sql.Date sqlDate2 = (java.sql.Date)today;                // 실제로는 sql.Date형이었던 날짜형을 util.Date형인 today에 담겨 있다면 이 방법도 가능
        System.out.println(sqlDate);

        /* 설명. java.sql.Date -> java.util.Date */
        java.util.Date utilDate = sqlDate;                              // 다형성 적용
        System.out.println(utilDate);

    }
}
