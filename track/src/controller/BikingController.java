package controller;

import model.SportArten;
import view.BikingView;

public class BikingController {
	double time;
	double distance;

	public BikingController(int time, int distance) {
		SportArten sportArten = new SportArten();
		this.time = time;
		this.distance = distance;
		BikingView bikingViewResult = new BikingView((int)sportArten.biking(time, distance));
	}
}
