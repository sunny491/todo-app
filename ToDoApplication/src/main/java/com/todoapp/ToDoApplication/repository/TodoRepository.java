package com.todoapp.ToDoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todoapp.ToDoApplication.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> { }
