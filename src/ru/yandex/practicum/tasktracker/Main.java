package ru.yandex.practicum.tasktracker;


import ru.yandex.practicum.tasktracker.model.Epic;
import ru.yandex.practicum.tasktracker.model.Subtask;
import ru.yandex.practicum.tasktracker.model.Task;
import ru.yandex.practicum.tasktracker.model.TaskStatus;
import ru.yandex.practicum.tasktracker.service.TaskManager;

public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");
        TaskManager manager = new TaskManager();
        Task task = new Task("Написать код", "Написать код для финального тз 4 спринта", TaskStatus.DONE, manager.getId());
        manager.createTask(task);
        Epic epic = new Epic("написать код", "написать код для приложения", TaskStatus.NEW, manager.getId());
        manager.createEpic(epic);
        Subtask subtask = new Subtask("Создать пакет", "создать пакет для хранения классов", TaskStatus.NEW, manager.getId(), epic.getId());
        manager.createSubtask(subtask);
        Subtask subtask2 = new Subtask("Создать", "создать пакет", TaskStatus.DONE, manager.getId(), epic.getId());
        manager.createSubtask(subtask2);
        Subtask subtask3 = new Subtask("Создать пакет", "создать пакет для хранения классов", TaskStatus.NEW, manager.getId(), epic.getId());
        manager.createSubtask(subtask3);
        Subtask subtask1 = new Subtask("Создать проект", "Создать проект в IDE", TaskStatus.NEW, manager.getId(), epic.getId());
        manager.updateSubtask(subtask1);


        System.out.println(manager.getTasks());
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubtasks());
    }
}