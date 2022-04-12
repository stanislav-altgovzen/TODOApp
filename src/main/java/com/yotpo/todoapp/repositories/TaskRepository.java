package com.yotpo.todoapp.repositories;

import com.yotpo.todoapp.entities.Task;
import com.yotpo.todoapp.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> { }
