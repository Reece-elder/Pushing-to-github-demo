package com.qa.test.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.mockitoDemo.Barista;
import com.qa.mockitoDemo.Drink;
import com.qa.mockitoDemo.DrinkProcesses;

@ExtendWith(MockitoExtension.class)
public class BaristaTest {
	
	@Mock
	DrinkProcesses mockProcess;
	
	@InjectMocks
	Barista barista;
	
	Drink testDrink = new Drink("test-type", "test-size", "test-user", true, true);
	
	@Test
	public void makeLatteTest() {
		
		Mockito.when(mockProcess.makeEspresso(testDrink)).thenReturn("espresso done");
		
		String result = testDrink.getType() + " finished!";
		
		Assertions.assertEquals(result, "test-type finished!");
		
	}

}
