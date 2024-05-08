package controller;

import model.SportArten;
import view.BikingView;
import view.SoccerView;

public class SoccerController {
	double time;
	double weight;
		public SoccerController(int time, int weight){
			SportArten sportArten = new SportArten();
			this.time = time;
			this.weight = weight;
			SoccerView soccerViewResult = new SoccerView((int)sportArten.football(time, weight));
		}
}
