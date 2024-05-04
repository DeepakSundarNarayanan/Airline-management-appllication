package edu.neu.csye6200.utils;

import java.security.PublicKey;

public class Passengers {
	
	private String name;
	final String phoneNumber;
	private String username;	
	private String password;
	private String passport;
	private boolean isBooked;
	
	public Passengers(String name, String phoneNumber, String username, String password, String passport)
	{
		this.name=name;
		this.phoneNumber = phoneNumber;
		this.username=username;
		this.password=password;
		this.passport=passport;
	}

	public Passengers (String csvString) {
		String[] fields = csvString.split(",");
		this.name = fields[0];
		this.phoneNumber = fields[1];
		this.username = fields[2];
		this.password = fields[3];
		this.passport = fields[4];
	}
	
	public void setPassport(String passport)
	{
		this.passport=passport;
	}
	
	public String getPassport()
	{
		return passport;
	}
	
	public void setPassword(String pass)
	{
		this.password=pass;
	}
	
	public void setBooked(boolean isBooked)
	{
		this.isBooked=isBooked;
	}
	
	public boolean getBooked()
	{
		return isBooked;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public boolean isBooked() {
		return isBooked;
	}

	@Override
	public String toString() {
		return this.name + "," +
				this.phoneNumber + "," +
				this.username  + "," +
				this.password  + "," +
				this.passport;
	}
}
