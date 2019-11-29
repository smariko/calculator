package com.mariko.calculator;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
* Calculator class definition.
*/
@Service
public class Calculator {
	@Cacheable({"sum", "minus"})
	int sum(int a, int b) {
		return a + b;
	}

	int minus(int a, int b) {
		return a - b;
	}
}
