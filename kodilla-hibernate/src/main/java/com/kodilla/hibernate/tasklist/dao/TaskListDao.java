package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.com.kodilla.hibernate.TaskList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskListDao extends CrudRepository<TaskList, Integer> {
    List<TaskList> findByListName(String listName);

}
