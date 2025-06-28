package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTestAAA {

    private Calculator calculator;

    // 🔧 Setup method: runs before each test
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup done");
    }

    // 🧹 Teardown method: runs after each test
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown done");
    }

    // ✅ Test using Arrange-Act-Assert pattern
    @Test
    public void testAddition() {
        // Arrange
        int a = 5, b = 7;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(12, result);
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
    }
}
