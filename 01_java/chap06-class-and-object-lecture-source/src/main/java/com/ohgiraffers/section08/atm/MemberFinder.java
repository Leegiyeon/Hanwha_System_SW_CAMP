package com.ohgiraffers.section08.atm;

public class MemberFinder {

	public Member[] findAllMembers() {
		
		return MemberRepository.findAllMembers();
	}
}
