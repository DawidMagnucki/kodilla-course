package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;


public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Beginning of tests");
    }

    @BeforeEach
    void beforeEach() {
        testCounter++;
        System.out.println("This is test number " + testCounter);
    }

    @AfterEach
    void afterEach() {
        System.out.println("This is the end of test number " + testCounter);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("End of tests");
    }

    @Test
    void testCaseAddShape() {
        //Given
        Square square = new Square(2.5);
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(square);
        //Then
        Assertions.assertEquals(square, shapeCollector.getFigure(0));
    }

    @Test
    void testCaseRemoveShape() {
        //Given
        Square square = new Square(2.5);
        Circle circle = new Circle(2.5);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);

        //When
        shapeCollector.removeFigure(0);
        //Then
        Assertions.assertEquals(circle, shapeCollector.getFigure(0));
    }
}
