package com.mariko.calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CalculatorController {
	@Autowired
	private Calculator calculator;

	@RequestMapping(value = "/sum")
	public String sum(@RequestParam("a") Integer a,
			@RequestParam("b") Integer b) {
		return String.valueOf(calculator.sum(a, b));
	}

	@RequestMapping(value="/minus")
	public String minus(@RequestParam("a") Integer a,
			@RequestParam("b") Integer b) {
		return String.valueOf(calculator.minus(a, b));
	}
}
