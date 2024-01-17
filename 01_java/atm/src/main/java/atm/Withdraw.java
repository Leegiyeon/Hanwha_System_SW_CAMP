package atm;

import java.util.Scanner;

public class Withdraw {
    private double balance;         // 잔액 = balance
    private double withdraw;        // 출금액 = withdraw

    Deposit deposit = new Deposit();

    public void howMuch() {
        System.out.print("출금할 금액을 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        withdraw = sc.nextDouble();
        sumBalance();
    }

    public void sumBalance() {
        if (balance >= withdraw) {
            balance -= withdraw;
            System.out.println("출금 후 잔액은 " + balance + "원 입니다.");
            System.out.println("서비스를 이용해주셔서 감사합니다.");
        } else {
            System.out.println("잔액이 부족합니다");
            System.out.println("잔액은 " + balance + "원 입니다.");
            howMuch();
        }
    }
}
