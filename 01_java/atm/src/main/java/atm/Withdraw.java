package atm;

import java.util.Scanner;

public class Withdraw {
    private double balance;         // 잔액 = balance
    private double withdraw;        // 출금액 = withdraw

    public void howMuch() {
        System.out.print("출금할 금액을 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        withdraw = sc.nextDouble();
    }

    public void sumBalance() {
        balance -= withdraw;
        if (balance >= 0) {
            System.out.println("출금 후 잔액은 " + balance + "원 입니다.");
            System.out.println("서비스를 이용해주셔서 감사합니다.");
        } else {
            balance += withdraw;
            System.out.println("잔액이 부족합니다");
            howMuch();
        }
    }
}
