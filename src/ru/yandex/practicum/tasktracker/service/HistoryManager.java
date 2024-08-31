package ru.yandex.practicum.tasktracker.service;

import ru.yandex.practicum.tasktracker.model.Task;

import java.util.List;

public interface HistoryManager {

    void addToHistory(Task task);

    void removeFromHistory(int id);

    List<Task> getHistory();
}
