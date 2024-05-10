package controller;

public class WalkingController {

	public WalkingController() {

	}

	public int calculateWalking(int weight, int distance, int time, String metTxt) {
		double calories;
		int calcFact = 0;
		int calcDistance = distance;
		int calcWeight = weight;
		double calcTime = time / 60.0;
		String metCompareTxt = metTxt;
		// verbrauchte energie= strecke(km) * gewicht (kg) * 0.9
		// Calorie Consumption (kcal) = (Weight (kg) x Distance (km) x MET value) / Time
		// (hours)

//	    Slow jogging (5.0 mph or 8.0 km/h): 6 METs
//	    Running (6.0 mph or 9.7 km/h): 8 METs
//	    Running (7.0 mph or 11.3 km/h): 10 METs
//	    Running (8.0 mph or 12.9 km/h): 11.5 METs
//	    Running (9.0 mph or 14.5 km/h): 12.8 METs

		switch (metCompareTxt) {
		case "Laufen":
			calcFact = 6;
			break;
		case "Walking":
			calcFact = 8;
			break;
		case "Joggen":
			calcFact = 10;
			break;
		case "Rennen":
			calcFact = 11;
			break;
		}
		calories = ((calcWeight * calcDistance * calcFact) / calcTime)/10;

		return (int) calories;
	}
}
