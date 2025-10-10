package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        String toDoTask = "To do task 1";
        String progressTask = "Task 2 in progress";
        String doneTask = "Task 3 done";
        board.getToDoList().getTasks().add(toDoTask);
        board.getInProgressList().getTasks().add(progressTask);
        board.getDoneList().getTasks().add(doneTask);

        //Then
        assertEquals(toDoTask, board.getToDoList().getTasks().iterator().next());
        assertEquals(progressTask, board.getInProgressList().getTasks().iterator().next());
        assertEquals(doneTask, board.getDoneList().getTasks().iterator().next());
    }
}
