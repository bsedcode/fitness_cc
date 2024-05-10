package controller;

public class HandBallController {
	private 
	int calories;
	public HandBallController() {
		
	}
	
	public int calculateHandBall(int weight, int time) {
		double calcfactor = 1;
		if (weight < 75.0) {
			calcfactor = 0.9;
		}
		if (weight > 90.0) {
			calcfactor = 1.1;
		}
		calories = (int) (time * 14 * calcfactor);
		return calories;
	}
}
