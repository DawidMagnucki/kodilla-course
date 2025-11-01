package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.com.kodilla.hibernate.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "TO DO";
    private static final String DESCRIPTION = "To-Do list including daily tasks";

    @Test
    void findByListName() {
        //Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);
        taskListDao.save(taskList);

        //When
        taskListDao.findByListName(LISTNAME);

        //Then
        assertEquals(LISTNAME, taskList.getListName());

        //Clean Up
        taskListDao.deleteById(taskList.getId());

    }
}
