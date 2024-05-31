package ru.yandex.practicum.tasktracker.service.impl;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.tasktracker.model.Epic;
import ru.yandex.practicum.tasktracker.model.Subtask;
import ru.yandex.practicum.tasktracker.model.Task;
import ru.yandex.practicum.tasktracker.service.TaskManager;
import ru.yandex.practicum.tasktracker.utilities.Managers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InMemoryTaskManagerTest {


    @Test
    void equalsTwoTasksWithOneId() {
        Task taskOne = new Task();
        Task taskTwo = new Task();

        taskOne.setId(1);
        taskTwo.setId(1);

        assertEquals(taskOne, taskTwo, "Ошибка сравнения по ID");

    }

    @Test
    void equalsTwoEpicsWithOneId() {
        Epic epicOne = new Epic();
        Epic epicTwo = new Epic();

        epicOne.setId(1);
        epicTwo.setId(1);

        assertEquals(epicOne, epicTwo, "Ошибка сравнения по ID");

    }

    @Test
    void equalsTwoSubtaskWithOneId() {
        Subtask subtaskOne = new Subtask();
        Subtask subtaskTwo = new Subtask();

        subtaskOne.setId(1);
        subtaskTwo.setId(1);

        assertEquals(subtaskOne, subtaskTwo, "Ошибка сравнения по ID");

    }

    @Test
    void addNewTask() {
        TaskManager taskManager = Managers.getDefault();
        Task task = new Task();
        taskManager.createTask(task);

        final int taskId = task.getId();

        final Task savedTask = taskManager.getTaskById(taskId);

        assertNotNull(savedTask, "Задача не найдена.");
        assertEquals(task, savedTask, "Задачи не совпадают.");

        final List<Task> tasks = taskManager.getTasks();

        assertNotNull(tasks, "Задачи не возвращаются.");
        assertEquals(1, tasks.size(), "Неверное количество задач.");
        assertEquals(task, tasks.getFirst(), "Задачи не совпадают.");
    }

    @Test
    void addNewSubtask() {
        TaskManager taskManager = Managers.getDefault();
        Epic epic = new Epic();
        taskManager.createEpic(epic);

        final int epicId = epic.getId();

        final Epic savedEpic = taskManager.getEpicById(epicId);

        assertNotNull(savedEpic, "Задача не найдена.");
        assertEquals(epic, savedEpic, "Задачи не совпадают.");

        final List<Epic> epics = taskManager.getEpics();

        assertNotNull(epics, "Задачи не возвращаются.");
        assertEquals(1, epics.size(), "Неверное количество задач.");
        assertEquals(epic, epics.getFirst(), "Задачи не совпадают.");
    }


}