package controller;

public class SwimmController {
	int calories;

	public SwimmController() {

	}

	public int calculateSwimming(int time, boolean intensity) {
		// moderate geschwindigkeit 480 Kalorien/h 8 Kalorien/ min
		// intensive einheit 640 kalorien/h 11 kalorien/min
		int calcCalories=11;
		int calcTime=time;
		
		if (intensity == true) {
			calories=calcCalories * calcTime;
		} else {
			calcCalories= 8;
			calories=calcCalories * calcTime;
		}

		return calories;
	}
}
