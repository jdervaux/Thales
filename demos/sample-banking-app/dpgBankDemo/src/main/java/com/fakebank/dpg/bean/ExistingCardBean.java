package com.fakebank.dpg.bean;

public class ExistingCardBean {
	private String expDate;
	private String ccNumber;
	private String cvv;
	private String friendlyName;
	private String balance;

	public ExistingCardBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExistingCardBean(String expDate, String ccNumber, String cvv, String friendlyName, String balance) {
		super();
		this.expDate = expDate;
		this.ccNumber = ccNumber;
		this.cvv = cvv;
		this.friendlyName = friendlyName;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "ExistingCardBean [expDate=" + expDate + ", ccNumber=" + ccNumber + ", cvv=" + cvv + ", friendlyName="
				+ friendlyName + ", balance=" + balance + "]";
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
}
