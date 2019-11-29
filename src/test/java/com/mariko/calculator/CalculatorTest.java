package com.mariko.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
* Calculator Test class definition.
*/

public class CalculatorTest {

	private Calculator calculator = new Calculator();

	@Test1

	public void testSum() {
		assertEquals(5, calculator.sum(2, 3));
	}
	
	@Test2

	public void testMinus() {
		assertEquals(2, calculator.minus(4, 2));
	}
}
