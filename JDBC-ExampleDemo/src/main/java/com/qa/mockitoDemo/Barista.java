package com.qa.mockitoDemo;

public class Barista {

	DrinkProcesses process = new DrinkProcesses();

	public String makeLatte(Drink drink) {
		
		this.process.makeEspresso(drink);
		
		process.makeFrothyMilk(drink);
		
		if(drink.isExtras() == true) {
			process.addSauce(drink);
		}
		
		return drink.getType() + " finished!";
		
	}

}
