package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service("memberService")
public class MemberService {

    public final MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }


    // Memo. Primary concern 주요 관심사 -> 이것을 보호막으로 감싸면 그것이 바로 프록시
    public List<MemberDTO> findAllMembers() {
        System.out.println("target -> findAllMembers() 실행");
        return memberDAO.selectAllMembers();
    }

    public MemberDTO findMemberBy(int index) {
        System.out.println("target -> findMemberBy() 실행");
        return memberDAO.selectMemberBy(index);
    }
}
