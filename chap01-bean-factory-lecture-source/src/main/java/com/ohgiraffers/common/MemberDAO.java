package com.ohgiraffers.common;


/* 설명.
 *  DAO클래스는 Data Access Object의 줄임말로 Repository 계층과 마찬가지로 java application
 *  Database 를 연동 시켜 주기 위한 계층의 클래스로 활용된다.
* */

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


/* 설명. DB와 연동하기 위해 클래스에 추가하는 어노테이션(Bean으로 관리) */
@Repository

/* 설명. 클래ㅐ스에 계층의 의미 없이 Bean으로 관리될 클래스는 Component를 붙일 수 있다. */
//@Component
public class MemberDAO {

    private final Map<Integer, MemberDTO> meberMap;

    public MemberDAO() {
        meberMap = new HashMap<>();

        meberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        meberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
        meberMap.put(3, new MemberDTO(3, "user03", "pass03", "이순신"));
    }


    /* 설명. 회원 조회용 메소드 */
    public MemberDTO selectMember(int sequence) {
        return meberMap.get(sequence);
    }


    /* 설명. 회원 가입용 메소드 */
    public int insertMember(MemberDTO newMember) {
        int before = meberMap.size();

        meberMap.put(newMember.getSequence(), newMember);

        int after = meberMap.size();

        return after - before;
    }

}
