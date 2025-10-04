package com.kodilla.spring.intro.shape;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DrawerTestSuite {

    @Test
    public void DrawCircleTest() {
        //Given
        Drawer drawer = new Drawer(new Circle());
        //When
        String result = drawer.doDrawing();
        //Then
        assertEquals("This is a circle", result);
    }

    @Test
    public void DrawTriangleTest() {
        //Given
        Drawer drawer = new Drawer(new Triangle());
        //When
        String result = drawer.doDrawing();
        //Then
        assertEquals("This is a triangle", result);
    }
}
