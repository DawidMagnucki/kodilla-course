package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTestSuite {

    @Test
    void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        double num1 = 10.00;
        double num2 = 2.00;

        //When
        double addingResult = calculator.add(num1, num2);
        double subtractingResult = calculator.subtract(num1, num2);
        double multiplyingResult = calculator.multiply(num1, num2);
        double dividingResult = calculator.divide(num1, num2);

        //Then
        assertEquals(12.00, addingResult);
        assertEquals(8.00, subtractingResult);
        assertEquals(20.00, multiplyingResult);
        assertEquals(5.00, dividingResult);

    }
}
