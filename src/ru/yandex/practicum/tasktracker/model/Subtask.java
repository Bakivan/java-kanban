package ru.yandex.practicum.tasktracker.model;

public class Subtask extends Task {

    int epicId;

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }
}