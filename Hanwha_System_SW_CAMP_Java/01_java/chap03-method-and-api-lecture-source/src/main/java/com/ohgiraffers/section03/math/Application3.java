package com.ohgiraffers.section03.math;
import java.util.Random;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. 사용자 지정 범위의 난수를 발생시킬 수 있다.(ver.java.util.Random 클래스) */
        /* 설명. java.util.random 클래스는 메소드를 non-static 메소드로 제공한다. */

        Random rand = new Random();
        /* 목차. 1. 0 - 9 범위 난수 생성 */
        int rand1 = rand.nextInt(10);
        System.out.println(rand1);

        /* 목차. 2. 1 - 10 범위 난수 생성 */
        int rand2 = rand.nextInt(11) + 1;
        System.out.println(rand2);

        /* 목차. 3. 10 - 15 범위 난수 생성 */
        int rand3 = rand.nextInt(6) + 10;
        System.out.println(rand3);

        /* 목차. 4. -128 - 127 범위 난수 생성 */ // 총 범위 수: 256 초기 값: -128
        int rand4 = rand.nextInt(256) - 128;
        System.out.println(rand4);
    }
}
