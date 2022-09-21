package com.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestGreeting {

	@Test
	@DisplayName(value= "Test getMessage return a string of length less than or equal to Five")
	
	void testGetMessage() {
		Greeting grtObj=new Greeting();
		assertEquals(5, grtObj.getMessage().length());
	}

	@Test
	@DisplayName(value= "Test getMessage return a string Hello")
	
	void testGetMessageReturnValue() {
		Greeting grtObj=new Greeting();
		assertEquals("Hello", grtObj.getMessage().length());
	}

}
