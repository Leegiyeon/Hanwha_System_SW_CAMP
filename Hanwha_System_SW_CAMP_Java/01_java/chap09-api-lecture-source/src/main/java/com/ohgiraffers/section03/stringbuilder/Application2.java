package com.ohgiraffers.section03.stringbuilder;

public class Application2 {

    public static void main(String[] args) {

        /* 수업목표. StringBuilder의 자주사용되는 메소드 용법울 이해할 수 있다. */
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity());

        /* 설명. capacity(): 용량을 정수형으로 반환하는 메소드(초기 16 byte 할당) */
        for (int i = 0; i < 100; i++) {
            sb.append(i);

            /* 설명. 용량은 초과할 시, (용량 X2)+2 만큼씩 증가 */
            System.out.println("sb: " + sb);
            System.out.println("capacity: " + sb.capacity());
            System.out.println("hashCode: " + System.identityHashCode(sb));

        }

//        StringBuilder sb2 = new StringBuilder("javamariaDB");
        StringBuffer sb2 = new StringBuffer("javamariaDB");

        /* 필기.
         *  delete(): 시작 인데스와 종료 인데스를 이용하여 문자열에서 원하는 부분을 제거
         *  deleteCharAt(): 문자열을 인덱스를 사용하여 문자 제거
        * */
//        System.out.println("delete(): " + sb.delete(2,5));
//        System.out.println("deleteChartAt(): " + sb.deleteCharAt(0));

        /* 필기.
         *  insert(): 인자로 전달된 값을 문자열로 변환 후 지정한 인덱스 위치에 추가한다.
        * */

        System.out.println("inser(): " + sb2.insert(1, "vao"));
        System.out.println("inser(): " + sb2.insert(0, "j"));
        System.out.println("inser(): " + sb2.insert(sb2.length(), "jdbc"));

        /* 필기.
         *  reverse(): 문자열 인덱스 순번을 역순으로 재배열한다.
        * */

        System.out.println("reverse(): " + sb2.reverse());

        /* 필기. String 클래스와 동일한 메소드도 일부 제공된다. */

    }
}
