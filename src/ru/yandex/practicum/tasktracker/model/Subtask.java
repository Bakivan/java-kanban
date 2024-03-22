package ru.yandex.practicum.tasktracker.model;

public class Subtask extends Task {

    int epicId;

    public Subtask(String name, String description, TaskStatus status, int id, int relatedEpicId) {
        super(name, description, status, id);
        this.epicId = relatedEpicId;
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }
}