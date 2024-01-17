package com.ohgiraffers.section08.atm;

public class Member {

	private int accountNumber;
	private String name;
	private String pwd;
	private double balance;
	
	public Member() {}

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

	public String getInformation() {
		return "Member{" +
				"accountNumber=" + accountNumber +
				", name='" + name + '\'' +
				", pwd='" + pwd + '\'' +
				", balance=" + balance +
				'}';
	}
}
