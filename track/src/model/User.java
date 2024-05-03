package model;

import java.util.Date;

public class User {
	private String name;
	Date birthDate;
	private double weights;
	private double height;
	private boolean isMen;
	private double bmi;
	private double calories;
	private double calcValue;
	
	public User (String valueName, Date birthDate, double weight, double valueHeight, boolean valueGender) {
		this.name= valueName;
		this.birthDate= birthDate;
		this.weights= weight;
		this.height= valueHeight;
		this.bmi = weights/(height*height);
		this.isMen= true;
	}
	public double getBmi() {
		return bmi;
	}
}
