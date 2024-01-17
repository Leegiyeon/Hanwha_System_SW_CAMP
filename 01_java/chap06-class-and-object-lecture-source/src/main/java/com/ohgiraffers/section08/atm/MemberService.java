package com.ohgiraffers.section08.atm;

import java.util.Scanner;

public class MemberService {

	public void signUpMembers(int idx) {

		Member[] members = new Member[10];
		Scanner sc = new Scanner(System.in);
		System.out.print("사용하실 계좌번호를 입력하세요:");
		int accountNumber = sc.nextInt();
		System.out.print("사용하실 분의 이름을 입력하세요:");
		String name = sc.next();
		System.out.print("사용하실 비밀번호를 입력하세요:");
		String pwd = sc.next();
		double balance = 0.0;

		members[idx] = new Member(accountNumber, name, pwd, balance);
		
		MemberRegister memberRegister = new MemberRegister();
		memberRegister.regist(members);
	}

	public void showAllMembers() {

		MemberFinder finder = new MemberFinder();
		System.out.println("----------- 가입된 회원 목록 -------------");
		for(Member member : finder.findAllMembers()) {
			if(member != null) {
				System.out.println(member.getInformation());
			}
		}
		System.out.println("---------------------------------------");
	}

	public void signInMembers() {
		System.out.print("계좌번호를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int accountNumber = sc.nextInt();
		System.out.print("비밀번호를 입력해주세요");
		int pwd = sc.nextInt();

//		for(int i = 0; i < 10; i++){
//			if (accountNumber)
//		}


	}
}
