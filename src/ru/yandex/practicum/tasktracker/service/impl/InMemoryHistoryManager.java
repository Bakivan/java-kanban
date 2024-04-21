package ru.yandex.practicum.tasktracker.service.impl;

import ru.yandex.practicum.tasktracker.model.Task;
import ru.yandex.practicum.tasktracker.service.HistoryManager;

import java.util.LinkedList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private static final int SIZE_OF_REQUEST_HISTORY = 10;
    private final List<Task> history = new LinkedList<>();

    @Override
    public void addToHistory(Task task) {
        if (task != null) {
            if (history.size() == SIZE_OF_REQUEST_HISTORY) {
                history.removeFirst();
            }
            history.add(task);
        }
    }

    @Override
    public List<Task> getHistory() {
        return List.copyOf(history);
    }
}
