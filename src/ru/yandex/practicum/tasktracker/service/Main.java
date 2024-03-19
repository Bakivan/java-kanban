package ru.yandex.practicum.tasktracker.service;


import ru.yandex.practicum.tasktracker.model.Epic;
import ru.yandex.practicum.tasktracker.model.Subtask;
import ru.yandex.practicum.tasktracker.model.Task;

public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");
        TaskManager manager = new TaskManager();
        Task task = new Task("Написать код", "Написать код для финального тз 4 спринта", TaskStatus.DONE);
        manager.createTask(task);
        Epic epic = new Epic("написать код", "написать код для приложения", TaskStatus.NEW, manager.idSubtask);
        manager.createEpic(epic);
        Subtask subtask = new Subtask("Создать пакет", "создать пакет для хранения классов", TaskStatus.NEW);
        manager.createSubtask(subtask);
        Subtask subtask1 = new Subtask("Создать проект", "Создать проект в IDE",TaskStatus.NEW);
        manager.updateSubtask(3, subtask1);


        System.out.println(manager.taskMap);
    }
}
