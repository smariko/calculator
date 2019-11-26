package com.mariko.calculator;
import org.springframework.stereotype.Service;


/**
* Calculator class definition.
*/
@Service
public class Calculator {
	int sum(int a, int b) {
		return a + b;
	}
}
