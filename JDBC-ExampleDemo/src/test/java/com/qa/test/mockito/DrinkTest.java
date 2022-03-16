package com.qa.test.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.mockitoDemo.Drink;

@ExtendWith(MockitoExtension.class)
public class DrinkTest {
	
	@Mock
	Drink mockDrink;
	
	@Test
	public void mockitoDemo() {
		Mockito.when(mockDrink.getType()).thenReturn("test-type");
		
		System.out.println(mockDrink.getType());
	}

}
