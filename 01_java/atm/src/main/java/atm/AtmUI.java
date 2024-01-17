package atm;

import java.util.Scanner;

public class AtmUI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean isOn = true;
        boolean login = false;
        int tmp=0; //member index

        while (isOn) {
            System.out.println("====    ATM    ====");
            System.out.println("==== 1.  입금   ====");
            System.out.println("==== 2.  출금   ====");
            System.out.println("==== 3. 잔액조회 ====");
//            System.out.println("==== 4. 회원가입 ====");      추후 개발 예정


            System.out.println("PLEASE ENTER THE NUMBER: ");

            int input = sc.nextInt();

            Member member = new Member();

            // 각 기능 별 접근 시, 로그인 추후 개발 예정
            if (input == 1){
                if(login){
                    member.login();
                }else {
                    Deposit deposit = new Deposit();
                    deposit.howMuch();
                    deposit.sumBalance();
                }
            } else if (input == 2) {
                Withdraw withdraw = new Withdraw();
                withdraw.howMuch();
                withdraw.sumBalance();
            } else if (input == 3) {
                Balance balance = new Balance();
                balance.printBalance();
            } else if (input == 4) {
                member.signUp(tmp);
            } else if (input == 9) {
                System.out.println("ATM이 종료됩니다.");
                isOn = false;
            }
            tmp++;
        }
    }
}
