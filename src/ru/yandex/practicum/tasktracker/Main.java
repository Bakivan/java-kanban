package ru.yandex.practicum.tasktracker;


import ru.yandex.practicum.tasktracker.model.Epic;
import ru.yandex.practicum.tasktracker.model.Subtask;
import ru.yandex.practicum.tasktracker.model.Task;
import ru.yandex.practicum.tasktracker.model.TaskStatus;
import ru.yandex.practicum.tasktracker.service.TaskManager;
import ru.yandex.practicum.tasktracker.utilities.Managers;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");
        TaskManager inMemoryTaskManager = Managers.getDefault();

        Task task1 = new Task();
        Task task2 = new Task();

        inMemoryTaskManager.createTask(task1);
        inMemoryTaskManager.createTask(task2);

        System.out.println(inMemoryTaskManager.getTasks());
        System.out.println();

        System.out.println(inMemoryTaskManager.getTasks());
        System.out.println(inMemoryTaskManager.getHistoryManager());

        Epic epic1 = new Epic();
        Epic epic2 = new Epic();

        Subtask subtask1 = new Subtask();
        Subtask subtask2 = new Subtask();
        Subtask subtask3 = new Subtask();


        inMemoryTaskManager.createEpic(epic1);
        inMemoryTaskManager.createEpic(epic2);

        inMemoryTaskManager.createSubtask(subtask1);
        inMemoryTaskManager.createSubtask(subtask2);
        inMemoryTaskManager.createSubtask(subtask3);

        System.out.println(inMemoryTaskManager.getSubtasks());
        System.out.println();

        System.out.println(inMemoryTaskManager.getEpics());
        System.out.println(inMemoryTaskManager.getSubtasks());
        System.out.println();

        inMemoryTaskManager.clearSubtasks();
        System.out.println(inMemoryTaskManager.getEpics());
        System.out.println();

        System.out.println(inMemoryTaskManager.getHistoryManager());

    }

}