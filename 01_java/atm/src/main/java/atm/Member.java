package atm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Member {
    private int accountNumber;
    private String name;
    private String pwd;
    private double balance;

    public Member() {
    }

    Member[] members = new Member[6];



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
        System.out.print("이름을 입력해주세요: ");
        name = sc.nextLine();
        System.out.print("사용하실 비밀번호를 입력해주세요: ");
        pwd = sc.nextLine();
        members[id] = new Member(accountNumber, name, pwd, 0);
        System.out.println("가입된 회원정보는 " + Arrays.toString(members) + " 입니다.");
        System.out.println("가입된 회원정보는 " + members[id] + " 입니다.");
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("계좌번호를 입력해주세요: ");
        accountNumber = sc.nextInt();


//        if(members.equals(members[].accountNumber){
//            System.out.print("비밀번호를 입력해주세요: ");
//            pwd = sc.nextLine();
//        }


    }


    // 기존 가입 회원
    public void memberManager(){
        members[3] = new Member (4444, "Wendy", "abcd1234", 4320000.0);
        members[4] = new Member (2222, "John", "qwer1234", 41150000.0);
        members[5] = new Member (3333, "Suzy", "qwer4321", 60000000.0);
    }
}

