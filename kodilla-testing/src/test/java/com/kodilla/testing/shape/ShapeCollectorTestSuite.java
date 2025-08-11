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

    @Nested
    @DisplayName("Tests for square")
    class SquareTests {
        @Test
        void testCaseAddSquare() {
            //Given
            Square square = new Square(2.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            String result = shapeCollector.addFigure(square);
            //Then
            Assertions.assertEquals("Square", result);
        }

        @Test
        void testCaseRemoveSquare() {
            //Given
            Square square = new Square(2.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);
            //When
            shapeCollector.removeFigure(square);
            //Then
            Assertions.assertFalse(shapeCollector.shapes.contains(square));
        }

        @Test
        void testCaseGetSquare() {
            //Given
            Square square = new Square(2.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);
            //When
            shapeCollector.getFigure(0);
            //Then
            Assertions.assertEquals("Square", shapeCollector.getFigure(0).getShapeName());
        }

        @Test
        void testCaseShowSquares() {
            //Given
            Square square = new Square(2.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(square);

            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Square Square", square.getShapeName());
        }
    }

    @Nested
    @DisplayName("Tests for circle")
    class CircleTests {
        @Test
        void testCaseAddCircle() {
            //Given
            Circle circle = new Circle(2.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(circle);
            //Then
            Assertions.assertEquals("Circle", shapeCollector.getFigure(0));
        }

        @Test
        void testCaseRemoveCircle() {
            //Given
            Circle circle = new Circle(2.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);
            //When
            shapeCollector.removeFigure(circle);
            //Then
            Assertions.assertFalse(shapeCollector.shapes.contains(circle));        }

        @Test
        void testCaseGetCircle() {
            //Given
            Circle circle = new Circle(2.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);
            //When
            shapeCollector.getFigure(0);
            //Then
            Assertions.assertEquals("Circle", shapeCollector.getFigure(0).getShapeName());
        }

        @Test
        void testCaseShowCircles() {
            //Given
            Circle circle = new Circle(2.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(circle);
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Circle Circle", result);
        }
    }

    @Nested
    @DisplayName("Tests for triangle")
    class TriangleTests {
        @Test
        void testCaseAddTriangle() {
            //Given
            Triangle triangle = new Triangle(3.0,4.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(triangle);
            //Then
            Assertions.assertEquals("Triangle", shapeCollector.getFigure(0));
        }

        @Test
        void testCaseRemoveTriangle() {
            //Given
            Triangle triangle = new Triangle(3.0,4.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(triangle);
            //When
            shapeCollector.removeFigure(triangle);
            //Then
            Assertions.assertFalse(shapeCollector.shapes.contains(triangle));        }

        @Test
        void testCaseGetTriangle() {
            //Given
            Triangle triangle = new Triangle(3.0,4.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(triangle);
            //When
            shapeCollector.getFigure(0);
            //Then
            Assertions.assertEquals("Triangle", shapeCollector.getFigure(0).getShapeName());
        }

        @Test
        void testCaseShowTriangles() {
            //Given
            Triangle triangle = new Triangle(3.0,4.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(triangle);
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals("Triangle Triangle", result);
        }
    }
}
