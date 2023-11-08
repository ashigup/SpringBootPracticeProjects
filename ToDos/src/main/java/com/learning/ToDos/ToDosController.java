package com.learning.ToDos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todos")
public class ToDosController {

    @Autowired
    TaskService taskService;
    @GetMapping
    public List<Task> listTasks(){
        return taskService.allTask();
    }

    @PostMapping("/create-task")
    public Task insertTask(@RequestBody Map<String, String> payload) {
        return taskService.insertTask(payload.get("task"));
    }

    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @PostMapping("/delete")
    public void deleteTask(@RequestBody Task task){
        taskService.deleteTask(task);
    }
}
