package com.learning.ToDos;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

enum State{
    NOT_STARTED,
    PROGRESS,
    COMPLETED
}

@Data
@NoArgsConstructor
@Document("ToDos")
public class Task {
    @Id
    private UUID taskId;
    private String name;
    private State status;

    public Task(String name) {
        this.name = name;
        this.taskId = UUID.randomUUID();
        this.status = State.NOT_STARTED;
    }

    public Task(UUID taskId, String name, State status) {
        this.name = name;
        this.taskId = taskId;
        this.status = status;
    }
}
