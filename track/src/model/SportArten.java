package model;

public class SportArten {

	double calories;
	
	public double walking(double weight, double distance) {
		// verbrauchte energie= strecke(km) * gewicht (kg) * 0.9
		double calcFactor = 0.9;
		calories = distance * weight * calcFactor;
		return calories;
	}

	public double football(int time, double weight) {
		/*
		 * Fußball ( Durchschnittswerte gekoppelt an Spielzeit ) 8kcal / min bei 75kg-90
		 * kg – Faktor 1 <75kg - Faktor 0.9 > 90kg - Faktor 1.1
		 */
		// factor used for calory calculation depends on body weight
		double calcfactor = 1;
		if (weight < 75.0) {
			calcfactor = 0.9;
		}
		if (weight > 90.0) {
			calcfactor = 1.1;
		}
		calories = time * 8 * calcfactor;
		return (int)calories;
	}

//	Radfahren ( gekoppelt an Strecke und Geschwindigkeit )
//	Pro Stunde:
//	Geschwindigkeit bis 15 km/h ≈ 300 kcal
//	Geschwindigkeit bis 18 km/h ≈ 420 kcal
//	Geschwindigkeit bis 22 km/h ≈ 600 kcal
//	Geschwindigkeit bis 28 km/h ≈ 850 kcal
//	Geschwindigkeit über 28 km/h ≈ 1.000 kcal
//	
//	Pro Minute:
//	Geschwindigkeit bis 15 km/h ≈ 5 kcal
//	Geschwindigkeit bis 18 km/h ≈ 7 kcal
//	Geschwindigkeit bis 22 km/h ≈ 10 kcal
//	Geschwindigkeit bis 28 km/h ≈ 14.1 kcal
//Geschwindigkeit über 28 km/h ≈ 16.6 kcal
	
	//Distance in km and time in minutes
	public double biking(double distance, double time) {
		int timeCalc= (int) time;
		int distanceCalc= (int) distance;
		int averagespeed = (int) (distanceCalc / (timeCalc / 60));
		
		// calories per minute variable to calculate the return value calories
		double calcCalories = 0;

		if (averagespeed <= 15) {
			calcCalories = 5;
		}
		else if (averagespeed > 15 && averagespeed <= 18) {
			calcCalories = 7;
		}
		else if (averagespeed > 18 && averagespeed <= 22) {
			calcCalories = 10;
		}
		else if (averagespeed > 22 && averagespeed <= 28) {
			calcCalories = 14.1;
		}
		else {
			calcCalories = 16.6;
		}
		calories = time * calcCalories;

		return (int)calories;
	}
	public double handBall(int time, double weight) {
		/*
		 * Handball ( Durchschnittswerte gekoppelt an Spielzeit ) 14kcal / min bei 75kg-90
		 * kg – Faktor 1 <75kg - Faktor 0.9 > 90kg - Faktor 1.1
		 */
		// factor used for calory calculation depends on body weight
		double calcfactor = 1;
		if (weight < 75.0) {
			calcfactor = 0.9;
		}
		if (weight > 90.0) {
			calcfactor = 1.1;
		}
		calories = time * 14 * calcfactor;
		return calories;
	}
	public double swimming(int time, double weight) {
		/*
		 * Schwimmen ( Durchschnittswerte gekoppelt an Spielzeit ) 10kcal / min bei 75kg-90
		 * kg – Faktor 1 <75kg - Faktor 0.9 > 90kg - Faktor 1.1
		 */
		// factor used for calory calculation depends on body weight
		double calcfactor = 1;
		if (weight < 75.0) {
			calcfactor = 0.9;
		}
		if (weight > 90.0) {
			calcfactor = 1.1;
		}
		calories = time * 10 * calcfactor;
		return calories;
	}
}
