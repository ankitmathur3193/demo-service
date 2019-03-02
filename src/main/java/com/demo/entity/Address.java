package com.demo.entity;

public class Address {

	private String state;
	private Integer pinCode;
	private String streetName;

	public Address(String state, Integer pinCode, String streetName) {
		super();
		this.state = state;
		this.pinCode = pinCode;
		this.streetName = streetName;
	}

	public Address() {
		super();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

}
