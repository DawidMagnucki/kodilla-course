package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    List<Shape> shapes = new ArrayList<>();


    public String addFigure(Shape shape) {
        return "test";
    }

    public void removeFigure(Shape shape) {
        System.out.println("test");
    }

    public Shape getFigure(int n) {
        return shapes.get(n);
    }

    public String showFigures() {
        return "test";
    }

}
