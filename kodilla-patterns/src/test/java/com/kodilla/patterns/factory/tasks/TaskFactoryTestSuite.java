package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {

    @Test
    void testShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.createTask(TaskFactory.SHOPPING_TASK);
        shopping.executeTask();
        //Then
        assertEquals("Buy groceries", shopping.getTaskName());
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.createTask(TaskFactory.PAINTING_TASK);
        painting.executeTask();
        //Then
        assertEquals("Wall painting", painting.getTaskName());
        assertTrue(painting.isTaskExecuted());
    }

    @Test
    void testDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.createTask(TaskFactory.DRIVING_TASK);
        driving.executeTask();
        //Then
        assertEquals("Taxi to mall", driving.getTaskName());
        assertTrue(driving.isTaskExecuted());
    }
}
