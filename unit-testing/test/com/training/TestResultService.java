package com.training;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TestResultService {
	ResultService service;
	
	@BeforeAll
	static void setUP() {
		System.out.println("Before All Called");
	}
	@AfterAll
	static void tearDown() {
		System.out.println("Ater All Called");
	}
	@Test
	@DisplayName(value="Find Result Should not Return Null")
	void testFindResultForNotNull() {
		assertNotNull(service.findResult(70));
	}
	
	@Test
	@DisplayName(value="Find Result Should Grade B for Marks 0 to 60")
	void testFindResultfirstCondition() {
		assertEquals("B",service.findResult(50));
	}
	
	
	
	@Test
	@DisplayName(value="Combined Test for FindResult Method")
	void testResultCombined() {
		
		/*
		 * assertAll (String,Executable)
		 * Executable is a varargs(can pass one or more values)
		 * denotes by three dots ...
		 * and Executable is a functional interface
		 * which has one method execute
		 * what is passed here is the implementation of execuatable
		 */
		
		
		
		assertAll("Multiple Tests",
				()->assertEquals("B",service.findResult(52)),
				()->assertEquals("C",service.findResult(75)),
				()->assertEquals("0",service.findResult(93))
				);
	}
	@Test
	//@Disabled("Disabled waiting for detailed requirement")
	@DisplayName(value="overloaded findResult with String Should Throw Number Format"
	+" Exception and it Should return A for marks less than or equal to 70 and 0 for greater than 70")
	void testFindResultReturnValue() {
		assertAll("Testing find Result Method",()->{
		
			assertThrows(NumberFormatException.class,
					()->service.findResult("Fifty"));
		},
				()->assertEquals("A",service.findResult("60")),
				()->assertEquals("0",service.findResult("80")));

		}
	@ParameterizedTest
	@ValueSource()
	@DisplayName("Test getName Method has non null values in position 1,3,5")
	void testForNotNull(int pos) {
		assertNotNull(service.getNames().get(pos));
	}
	
	
	@ParameterizedTest
	@ValueSource(ints= {1,3,5})
	@DisplayName("Using Assumptions -Test getName Method has non null values in position 1,3,5")
	void testForNotNullWithAssumptions(int pos) {
		String os=System.getProperty("os.name");
	//	long freeMemory=Runtime.getRuntime()
		assertNotNull(service.getNames().get(pos));
	}
	
	@BeforeEach
	void init(TestInfo info) {
		service=new ResultService();
		System.out.println("Called Before :="+info.getTestMethod().get().getName());
		
	}
	@AfterEach
	void destroy(TestInfo info) {
		service=null;
		System.out.println("Called After :="+info.getTestMethod().get().getName());
	}

}
