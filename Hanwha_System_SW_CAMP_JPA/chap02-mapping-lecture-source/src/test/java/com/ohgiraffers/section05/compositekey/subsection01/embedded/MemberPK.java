package com.ohgiraffers.section05.compositekey.subsection01.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

/* 설명.
 *  Embeddable 타입은 하나의 값의 묶음이자 불변객체로 다루는 타입이다.(불변 객체: setter가 없고 새로운 객체 생성)
 *  그리고 equals, hashCode를 반드시 오버리아딩 한다.
 *  VO와 유사하며 @EmbeddedID로 복합키를 표현하고자 할 때 사용된다.
* */

@Embeddable
public class MemberPK implements Serializable {
    @Column(name = "member_no")
    private int memberNo;
    @Column(name = "member_id")
    private String memberId;

    public MemberPK() {
    }

    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
    }
}
