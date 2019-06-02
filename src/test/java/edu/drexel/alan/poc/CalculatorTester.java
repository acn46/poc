package edu.drexel.alan.poc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTester {

	@Before
	public void setUp() throws Exception {
		System.out.println("Setup called");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Teardown called");
	}

	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		int result = calc.add(1, 2);
		assertTrue(result == 3);
	}
	
	@Test
	public void testAdd2() {
		Calculator calc = new Calculator();
		int result = calc.add(1, 2);
		assertFalse(result != 3);
	}
	
	@Test
	public void testSubtract() {
		Calculator calc = new Calculator();
		int result = calc.subtract(2, 1);
		assertTrue(result == 1);
	}
	
	@Test
	public void testSubtract2() {
		Calculator calc = new Calculator();
		int result = calc.subtract(2, 1);
		assertFalse(result != 1);
	}
	
	@Test
	public void testMultiply() {
		Calculator calc = new Calculator();
		int result = calc.multiply(3, 4);
		assertTrue(result == 12);	
	}
	
	@Test
	public void testMultiply2() {
		Calculator calc = new Calculator();
		int result = calc.multiply(3, 4);
		assertFalse(result != 12);	
	}
	
	@Test
	public void testDivide() {
		Calculator calc = new Calculator();
		int result = calc.divide(9, 3);
		assertTrue(result == 3);	
	}
	
	@Test
	public void testDivide2() {
		Calculator calc = new Calculator();
		int result = calc.divide(9, 3);
		assertFalse(result != 3);	
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivide3() {
		Calculator calc = new Calculator();
		int result = calc.divide(9, 0);
	}

}
