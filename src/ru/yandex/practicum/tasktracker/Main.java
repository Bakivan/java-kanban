package ru.yandex.practicum.tasktracker;


import ru.yandex.practicum.tasktracker.exception.ManagerSaveException;
import ru.yandex.practicum.tasktracker.model.*;
import ru.yandex.practicum.tasktracker.service.impl.FileBackedTaskManager;
import ru.yandex.practicum.tasktracker.utilities.Managers;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");
        /*TaskManager inMemoryTaskManager = Managers.getDefault();

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
        */
        File file = new File("/Users/pavelvolcenko/Documents", "data.txt");
        FileBackedTaskManager fileTaskManager = Managers.getDefaultFileManager(file);

        Task task1 = new Task("Task1", "Desc1", TaskStatus.NEW);
        Task task2 = new Task("Task2", "Desc2", TaskStatus.NEW);
        Task task3 = new Task("Task3", "Desc3", TaskStatus.NEW);

        fileTaskManager.saveTask(task1);
        fileTaskManager.saveTask(task2);
        fileTaskManager.saveTask(task3);

        Task task1Clone = (Task) task1.clone();
        Task task2Clone = (Task) task2.clone();

        task1Clone.setStatus(TaskStatus.IN_PROGRESS);
        task2Clone.setStatus(TaskStatus.DONE);

        fileTaskManager.updateTask(task1Clone);
        fileTaskManager.updateTask(task2Clone);

        Epic epic1 = new Epic("Epic1", "Desc1");
        Epic epic2 = new Epic("Epic2", "Desc2");

        Subtask subtask1 = new Subtask("Subtask1", "Desk1");
        Subtask subtask2 = new Subtask("Subtask2", "Desk2");
        Subtask subtask3 = new Subtask("Subtask3", "Desk3");

        fileTaskManager.saveEpic(epic1);
        fileTaskManager.saveEpic(epic2);
        subtask1.setEpicIdForThisSubtask(epic1.getId());
        subtask2.setEpicIdForThisSubtask(epic1.getId());
        subtask3.setEpicIdForThisSubtask(epic2.getId());

        fileTaskManager.saveSubtask(subtask1);
        fileTaskManager.saveSubtask(subtask2);
        fileTaskManager.saveSubtask(subtask3);

        fileTaskManager.getEpicById(epic1.getId());
        fileTaskManager.getSubtaskById(subtask1.getId());
        Task task22 = new Task("Task1", "Desc1", TaskStatus.NEW);
        ;

        fileTaskManager.saveTask(task22);

        System.out.println(fileTaskManager.getTasks());
        System.out.println(fileTaskManager.getEpics());
        System.out.println(fileTaskManager.getSubtasks());

        FileBackedTaskManager fileTaskManager2 = Managers.getLoadedFileManager(file);

        System.out.println(fileTaskManager2.getTasks());
        System.out.println(fileTaskManager2.getEpics());
        System.out.println(fileTaskManager2.getSubtasks());

    }

}