package com.kodilla.testing.shape;

public class Circle implements Shape{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "test";
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
