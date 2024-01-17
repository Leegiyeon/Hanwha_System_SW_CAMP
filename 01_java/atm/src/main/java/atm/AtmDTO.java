package atm;

import java.util.Date;

public class AtmDTO {

    private int accountNumber;      // 계좌번호 = id = accountNumber
    private String name;            // 고객이름 = name
    private String pwd;             // 비밀번호 = pwd
    private double balance;         // 잔액 = balance
    private double deposit;         // 입금액 = deposit
    private double withdraw;        // 출금액 = withdraw
    private java.util.Date enrollDate;

    public AtmDTO() {
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
//        Deposit deposit = new Deposit();
//        deposit.howMuch();
//        deposit.sumBalance();

//        Withdraw withdraw = new Withdraw();
//        withdraw.howMuch();
//        withdraw.sumBalance();

        this.balance = balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "AtmDTO{" +
                "accountNumber=" + accountNumber +
                ", name=" + name +
                ", balance=" + balance +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
