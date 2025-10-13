package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public Task createTask(String taskType) {
        return switch (taskType){
            case SHOPPING_TASK -> new ShoppingTask("Buy groceries", "Apples", 5.0);
            case PAINTING_TASK -> new PaintingTask("Wall painting", "White", "living room");
            case DRIVING_TASK -> new DrivingTask("Taxi to mall", "City Mall", "taxi");
            default -> null;
        };
    }
}
