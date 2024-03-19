package ru.yandex.practicum.tasktracker.model;

import ru.yandex.practicum.tasktracker.service.TaskStatus;

import java.util.ArrayList;

public class Epic extends Task {
    public Epic(String name, String description, TaskStatus status, ArrayList idSubtask) {
        super(name, description, status);
    }

    String name;
    String description;
    TaskStatus status;
    int id;
    ArrayList idSubtask;
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

    public ArrayList getIdSubtask() {
        return idSubtask;
    }

    public void setIdSubtusk(ArrayList idSubtusk) {
        this.idSubtask = idSubtusk;
    }



}
