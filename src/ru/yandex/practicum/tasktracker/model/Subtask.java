package ru.yandex.practicum.tasktracker.model;

import ru.yandex.practicum.tasktracker.service.TaskStatus;

import java.util.ArrayList;

public class Subtask extends Task {
    String name;
    String description;
    TaskStatus status;

    public Subtask(String name, String description, TaskStatus status) {
        super(name, description, status);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public TaskStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
