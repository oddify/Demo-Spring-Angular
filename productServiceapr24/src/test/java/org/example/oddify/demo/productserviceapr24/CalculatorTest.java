package org.example.oddify.demo.productserviceapr24;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Test when add two numbers, result is sum")
    void Test_whenAddTwoNumbers_ResultSum() {
        // Arrange
        int a = 2;
        int b = 2;

        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(3, result);
    }

    @Test
    void subtract() {
    }

    @Test
    void multiply() {
    }

    @Test
    void Test_DivideByZero_ThrowException() {
        // Arrange
        int a = 2;
        int b = 0;

        Calculator calculator = new Calculator();

        // Act & Assert
        assertThrows(ArithmeticException.class, () -> calculator.divide(a,b));


    }
}