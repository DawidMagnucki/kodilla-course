package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public Shape getFigure(int index) {
        return shapes.get(index);
    }

    public void removeFigure(int index) {
        shapes.remove(index);
    }

//
//    public String addFigure(Shape shape) {
//        return "test";
//    }
//
//    public void removeFigure(Shape shape) {
//        System.out.println("test");
//    }
//
//    public Shape getFigure(int n) {
//        return shapes.get(n);
//    }
//
//    public String showFigures() {
//        return "test";
//    }

}
