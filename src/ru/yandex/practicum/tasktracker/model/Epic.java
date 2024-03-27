package ru.yandex.practicum.tasktracker.model;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Integer> subtaskIds = new ArrayList<>();

    public Epic(String name, String description, TaskStatus status) {
        super(name, description, status);
    }

    public ArrayList<Integer> getSubtaskIds() {
        return subtaskIds;
    }

    public void setSubtaskIds(ArrayList<Integer> subtaskIds) {
        this.subtaskIds = subtaskIds;
    }
}