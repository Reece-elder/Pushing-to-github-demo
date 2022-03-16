package com.qa.mockitoDemo;

public class DrinkProcesses {

	public String makeEspresso(Drink drink) {
		System.out.println("Espresso done!");
		return "espresso done"; 
		
	}

	public String makeFrothyMilk(Drink drink) {
		System.out.println("Frothy milk done!");
		return "frothy milk done";
		
	}

	public String addSauce(Drink drink) {
		System.out.println("adding caramel sauce!");
		return "adding caramel sauce";
		
	}

}
