package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDAO {
    private final List<MemberDTO> memberList;

    public MemberDAO() {
        memberList = new ArrayList<>();
        memberList.add(new MemberDTO(1,"유관순"));
        memberList.add(new MemberDTO(2,"홍길동"));

    }

    public List<MemberDTO> selectAllMembers() {
        return memberList;
    }

    public MemberDTO selectMemberBy(int index) {
        for (MemberDTO memberDTO : memberList) {
            if (memberDTO.getId() == index) {
                return memberDTO;
            }
        }
        return memberList.get(index);
    }
}
