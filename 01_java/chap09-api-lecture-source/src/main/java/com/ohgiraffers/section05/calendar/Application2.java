package com.ohgiraffers.section05.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. java.util.Calendar 클래스의 사용법을 이해 */
        /* 필기.
         *  Date 형 대비 개선점
         *   1. timezone과 관련된 기능 추가
         *   2. 윤년 기능이 추가
         *   3. 날짜 및 시간 필드 개념 추가로 불 필요 메소드 명 줄임
        * */

        Calendar cal = Calendar.getInstance();
        System.out.println("cal = " + cal);

        Calendar cal2 = new GregorianCalendar();
        System.out.println("cal2 = " + cal2);

        int year = 1997;
        int month = 4;              // 입력하고자 하는 월 -1
        int dayOfMonth = 16;
        int hour = 5;
        int min = 30;
        int second = 0;

        Calendar birthDay = new GregorianCalendar(year, month, dayOfMonth, hour, min, second);
        System.out.println(birthDay);

        /* 설명. GregorianCalendar 객체가 가진 값 확인 */
        System.out.println("태어난 해: " + birthDay.get(1));
        System.out.println("태어난 해: " + birthDay.get(Calendar.YEAR));
        System.out.println("태어난 월: " + (birthDay.get(2) + 1));          // get() 메소드로 반환받은 값에 +1
        System.out.println("태어난 월: " + (birthDay.get(Calendar.MONTH)+1));
        System.out.println("태어난 일: " + birthDay.get(5));
        System.out.println("태어난 일: " + birthDay.get(Calendar.DAY_OF_MONTH));

        /* 설명. 요일에 대해 알아보자 */
        String day = "";
        switch (birthDay.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SUNDAY: day = "일"; break;
            case Calendar.MONDAY: day = "월"; break;
            case Calendar.TUESDAY: day = "화"; break;
            case Calendar.WEDNESDAY: day = "수"; break;
            case Calendar.THURSDAY: day = "목"; break;
            case Calendar.FRIDAY: day = "금"; break;
            case Calendar.SATURDAY: day = "토"; break;
        }
        System.out.println("내 생일은 " + day + "요일이야!");

        /* 설명. 하나씩 불러와 보자 */
        System.out.println("AM/PM: " + birthDay.get(Calendar.AM_PM));               // 0: 오전, 1: 오후
        System.out.println("hour of Day: " + birthDay.get(Calendar.HOUR_OF_DAY));   // 24H
        System.out.println("hour: " + birthDay.get(Calendar.HOUR));                 // 12H
        System.out.println("min: " + birthDay.get(Calendar.MINUTE));
        System.out.println("sec: " + birthDay.get(Calendar.SECOND));


        /* 설명. SimpleDateFormat 활용 */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E요일 hh:mm:ss");
        String birthDayString = sdf.format( new Date(birthDay.getTimeInMillis()));
        System.out.println("birthDayString = " + birthDayString);

    }
}
