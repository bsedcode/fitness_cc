package controller;

import model.SportArten;
import view.BikingView;

public class BikingController {
	private double time;
	private double distance;
	private int calories;

	public BikingController(int time, int distance) {
		SportArten sportArten = new SportArten();
		this.time = time;
		this.distance = distance;
		BikingView bikingViewResult = new BikingView((int) sportArten.biking(time, distance));
	}

	public int calculateBiking(double distance, double time) {
		int timeCalc = (int) time;
		int distanceCalc = (int) distance;
		int averagespeed = (int) (distanceCalc / (timeCalc / 60));

		// calories per minute variable to calculate the return value calories
		double calcCalories = 0;

		if (averagespeed <= 15) {
			calcCalories = 5;

		} else if (averagespeed > 15 && averagespeed <= 18) {
			calcCalories = 7;

		} else if (averagespeed > 18 && averagespeed <= 22) {
			calcCalories = 10;

		} else if (averagespeed > 22 && averagespeed <= 28) {
			calcCalories = 14.1;

		} else {
			calcCalories = 16.6;

		}
		calories = (int) (time * calcCalories);

		return (int) calories;
	}
}
