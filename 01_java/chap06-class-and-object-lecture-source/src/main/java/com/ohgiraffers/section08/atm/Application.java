package com.ohgiraffers.section08.atm;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		MemberService memberManager = new MemberService();
		int idx = 0;

		while(true) {
			System.out.println("======== 회원 관리 프로그램 ========");
			System.out.println("1. 입금");
			System.out.println("2. 출금");
			System.out.println("3. 잔액조회");
			System.out.println("9. 프로그램 종료");
			System.out.println("0. SIGN UP");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 : memberManager.signInMembers(); break;
				case 2 :  break;
				case 3 : ;
				case 9 : System.out.println("프로그램을 종료합니다."); return;
				case 0 : memberManager.signUpMembers(idx); idx++; break;
				default : System.out.println("잘못된 번호를 입력하셨습니다."); break;
			}

		}
	}
}
