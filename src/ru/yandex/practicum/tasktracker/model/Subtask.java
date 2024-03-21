package ru.yandex.practicum.tasktracker.model;

public class Subtask extends Task {

    int relatedEpicId;

    public int getRelatedEpicId() {
        return relatedEpicId;
    }

    public void setRelatedEpicId(int relatedEpicId) {
        this.relatedEpicId = relatedEpicId;
    }

    public Subtask(String name, String description, TaskStatus status, int id, int relatedEpicId) {
        super(name, description, status, id);
        this.relatedEpicId = relatedEpicId;
    }
}