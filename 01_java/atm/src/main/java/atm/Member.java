package atm;

import java.util.Random;
import java.util.Scanner;

public class Member {
    private int accountNumber;
    private String name;
    private String pwd;
    private double balance;
    Member[] members = new Member[6];

    public Member() {
    }

    public Member(int accountNumber, String name, String pwd, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pwd = pwd;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Member{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void signUp(int id) {
        Scanner sc = new Scanner(System.in);
        accountNumber = (int) (Math.random() + 1000);
        name = sc.nextLine();
        pwd = sc.nextLine();
        members[id] = new Member(accountNumber, name, pwd, 0);
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("계좌번호를 입력해주세요: ");
        accountNumber = sc.nextInt();
        System.out.print("비밀번호를 입력해주세요: ");
        pwd = sc.nextLine();

//        if(accountNumber acnum: Member )
    }
}

