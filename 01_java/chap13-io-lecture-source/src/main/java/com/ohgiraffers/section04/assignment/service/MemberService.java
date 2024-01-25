package com.ohgiraffers.section04.assignment.service;

import com.ohgiraffers.section04.assignment.aggregate.Member;
import com.ohgiraffers.section04.assignment.repository.MemberRepository;

import java.util.ArrayList;

/* 설명. 트랜잭션 성공실패 여부 확인 및 회원 관련 비즈니스 로직을 처리하는 클래스 */
public class MemberService {

    private  final MemberRepository mr = new MemberRepository();

    public MemberService() {
    }

    /* memo. Repository에 요청*/
    public void selectAllMembers() {
        ArrayList<Member> selectedMembers = mr.selectAllMembers();
//        System.out.println("=====Service에서 잘 반환되어 오는지 확인=====");
//        for(Member m: selectedMembers){
//            System.out.println(m);
//        }
    }

    /* 설명. 전달된 회원번호를 통해 Repository에 있는 memberList로부터 해당 회원 번호 찾아 반환받기 */
    public void selectMember(int memNo) {
        Member selectedMember = mr.selectMember(memNo);

        if(selectedMember == null) {
            System.out.println("찾으시는 회원이 없습니다.");
        }else {
            System.out.println("조회된 회원: " + selectedMember);
        }
    }
}
