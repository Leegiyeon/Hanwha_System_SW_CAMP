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
        return memberDAO.selectAllMembers();
    }

    public MemberDTO findMemberBy(long id) {
        return memberDAO.selectMemberBy(id);
    }
}
