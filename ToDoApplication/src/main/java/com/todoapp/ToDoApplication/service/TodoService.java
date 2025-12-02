package com.todoapp.ToDoApplication.service;

import com.todoapp.ToDoApplication.model.Todo;
import com.todoapp.ToDoApplication.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAllTasks() {
        return repository.findAll();
    }

    public Todo addTask(Todo todo) {
        return repository.save(todo);
    }

    public Todo updateTask(Long id, Todo todo) {
        Todo existing = repository.findById(id).orElseThrow();
        if (todo.getTitle() != null) existing.setTitle(todo.getTitle());
        existing.setCompleted(todo.isCompleted());
        return repository.save(existing);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
