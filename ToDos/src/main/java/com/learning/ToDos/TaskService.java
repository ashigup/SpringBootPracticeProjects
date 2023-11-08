package com.learning.ToDos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    MongoTemplate mongoTemplate;

    public Task insertTask(String name){
       return mongoTemplate.insert(new Task(name));
    }

    public List<Task> allTask(){
        return mongoTemplate.findAll(Task.class);
    }

    public Task updateTask(Task task){
        return mongoTemplate.save(task);
    }

    public void deleteTask(Task task){
        mongoTemplate.remove(task);
    }
}
