package model;

public class User {
	private String name;
	String birthDate;
	private double weight;
	private double height;
	private boolean isMen;
	private double bmi;
	private double calories;
	private double calcValue;
	
	public User (String valueName, String valuebirthDate, double valueWeight, double valueHeight, boolean valueGender) {
		this.name= valueName;
		this.birthDate= valuebirthDate;
		this.weight= valueWeight;
		this.height= valueHeight;
		this.bmi = weight/(height*height);
		this.isMen= true;
	}
	public double getBmi() {
		return bmi;
	}
}
