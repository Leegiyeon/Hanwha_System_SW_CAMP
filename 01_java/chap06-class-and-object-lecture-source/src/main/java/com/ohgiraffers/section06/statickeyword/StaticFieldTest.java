package com.ohgiraffers.section06.statickeyword;

import java.awt.event.WindowStateListener;

public class StaticFieldTest {

    private int nonStaticCount;
    private static int staticCount;

    /* 설명. 기본생성자 및 getter만 만들어보자 */

    public StaticFieldTest() {
    }

    public int getNonStaticCount() {
        return nonStaticCount;
    }

    public static int getStaticCount() {
        return staticCount;
    }

    /* 설명. setter를 대신해서 필드값을 가각 증가시킬 두 메소드 추가 */
    public void increaseNonstaticCount(){
        this.nonStaticCount++;
    }

    public static void increaseStaticCount(){
//        StaticFieldTest.staticCount++;
        staticCount++;
    }
}
