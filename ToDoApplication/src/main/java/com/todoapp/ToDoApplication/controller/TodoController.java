package com.todoapp.ToDoApplication.controller;

import com.todoapp.ToDoApplication.model.Todo;
import com.todoapp.ToDoApplication.service.TodoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*") // Allow frontend to access API
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAll() {
        return service.getAllTasks();
    }

    @PostMapping
    public Todo add(@RequestBody Todo todo) {
        return service.addTask(todo);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        return service.updateTask(id, todo);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteTask(id);
        return "Task Deleted";
    }
}
