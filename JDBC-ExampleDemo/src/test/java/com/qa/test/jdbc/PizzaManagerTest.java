package com.qa.test.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.qa.jdbc.Pizza;
import com.qa.jdbc.PizzaManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PizzaManagerTest {
	
	PizzaManager manager = new PizzaManager();
	
	Pizza testPizza1 = new Pizza("test-flavour1", 1, true);
	Pizza testPizza2 = new Pizza("test-flavour2", 2, false);
	
	String pizzaList = "[Pizza [pizzaId=1, flavour=test-flavour1, slices=1, stuffedCrust=true], Pizza [pizzaId=2, flavour=test-flavour2, slices=2, stuffedCrust=false]]";
	
	@BeforeEach
	public void setup() {
		manager.deleteAll();
		manager.addPizza(testPizza1);
		manager.addPizza(testPizza2);
	}
	
	@Test
	public void addSetPizzaTest() {
		
		// Arrange
		
		
		// Act
		boolean result = manager.addSetPizza();
		
		// Assert
		Assertions.assertTrue(result);
	}
	
	@Test
	public void addPizzaTest() {
		// Arrange
		Pizza testPizza = new Pizza("test flavour", 10, false);
		
		// Act
		boolean result = manager.addPizza(testPizza);
		
		// Assert
		Assertions.assertTrue(result);
		
	}
	
	@Test
	public void getAllPizzasTest() {
		
		// Arrange
		
		
		// Act
		String result = manager.getAllPizzas().toString();
		System.out.println(result);
		
		// Assert
		Assertions.assertEquals(result, pizzaList);
		
	}
	
	@Test
	public void getAllStuffedCrustTest() {
		
	}
	
}
