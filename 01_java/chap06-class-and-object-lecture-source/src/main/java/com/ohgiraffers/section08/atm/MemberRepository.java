package com.ohgiraffers.section08.atm;

public class MemberRepository {

    /* 설명. static 변수인 Member 객체 배열은 DB라고 하자 */
    private final static Member[] members;

    /* 설명. 현재 가입되어있는 회원수이자 마지막 회원번호 +1 을 의미 */
    private static int count;

    static {
        members = new Member[10];           // 관리할 회원은 최대 10명
    }

    public static boolean store(Member[] newMembers) {

        for(int i = 0; i < newMembers.length; i++) {
            members[count++] = newMembers[i];
        }

        return true;
    }

    public static Member[] findAllMembers() {

        return members;
    }
}
