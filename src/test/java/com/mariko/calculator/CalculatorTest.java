package com.mariko.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
* Calculator Test class definition.
*/

public class CalculatorTest {

	private Calculator calculator = new Calculator();

	@Test
	public void testMinusSum() {
		assertEquals(5, calculator.sum(2, 3));
//		assertEquals(2, calculator.minus(4, 2));
	}
}
