package ru.yandex.practicum.tasktracker.service.impl;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.tasktracker.model.Task;
import ru.yandex.practicum.tasktracker.model.TaskStatus;
import ru.yandex.practicum.tasktracker.service.HistoryManager;
import ru.yandex.practicum.tasktracker.utilities.Managers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InMemoryHistoryManagerTest {

    @Test
    void checkForDuplicationInHistory() {
        HistoryManager historyManager = Managers.getDefaultHistory();
        Task task = new Task("title", "desc", TaskStatus.NEW);
        final int sizeForCheckRequestSize = 19;
        for (int i = 0; i <= sizeForCheckRequestSize; i++) {
            historyManager.addToHistory(task);
        }
        List<Task> exampleOfRequestHistoryList = historyManager.getHistory();

        assertEquals(1, exampleOfRequestHistoryList.size(), "Ограничение дублирования "
                + "не работает");
    }

    @Test
    void add() {
        HistoryManager historyManager = Managers.getDefaultHistory();
        Task task = new Task("Test addNewTask", "Test addNewTask description", TaskStatus.NEW);
        historyManager.addToHistory(task);
        final List<Task> history = historyManager.getHistory();
        assertNotNull(history, "История не пустая.");
        assertEquals(1, history.size(), "История не пустая.");
    }
    @Test
    void delete() {
        HistoryManager historyManager = Managers.getDefaultHistory();
        Task task = new Task("Test addNewTask", "Test addNewTask description", TaskStatus.NEW);
        historyManager.addToHistory(task);
        historyManager.removeFromHistory(task.getId());
        final List<Task> history = historyManager.getHistory();
        assertEquals(0, history.size(), "История не пустая.");
    }

}