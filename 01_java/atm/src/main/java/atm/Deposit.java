package atm;

import java.util.Scanner;

public class Deposit {
    private double balance;         // 잔액 = balance
    private double deposit;

    public void howMuch() {
        System.out.print("입금할 금액을 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        deposit = sc.nextDouble();
    }

    public void sumBalance() {
        balance += deposit;
        System.out.println("입금 후 잔액은 " + balance + "원 입니다.");
        System.out.println("서비스를 이용해주셔서 감사합니다.");

    }
}
