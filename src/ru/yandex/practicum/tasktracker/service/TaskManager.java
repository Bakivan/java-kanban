package ru.yandex.practicum.tasktracker.service;

import ru.yandex.practicum.tasktracker.model.Task;
import ru.yandex.practicum.tasktracker.model.Subtask;
import ru.yandex.practicum.tasktracker.model.Epic;
import ru.yandex.practicum.tasktracker.model.TaskStatus;

import java.util.ArrayList;
import java.util.HashMap;


public class TaskManager {
    public HashMap<Integer, Task> tasks= new HashMap<>();
    public HashMap<Integer, Subtask> subtasks = new HashMap<>();
    public HashMap<Integer, Epic> epics = new HashMap<>();
    public int id = 0;

    public void createTask(Task task) {
        task.setId(id++);
        tasks.put(task.getId(), task);
    }

    public void createEpic(Epic epic) {
        epic.setId(id++);
        epics.put(epic.getId(), epic);
    }

    public void createSubtask(Subtask subtask) {
        subtask.setId(id++);
        if (subtask.getStatus() == null) {
            subtask.setStatus(TaskStatus.NEW);
        }
        Epic relatedEpic = epics.get(subtask.getRelatedEpicId());
        ArrayList <Integer> sintaskIds = relatedEpic.getSintaskIds();
        sintaskIds.add(subtask.getId());
        relatedEpic.setSintaskIds(sintaskIds);
        subtasks.put(subtask.getId(), subtask);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);

    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
    }

    public void printTasks() {

        for (HashMap.Entry entry: tasks.entrySet()) {
            System.out.println(entry);
        }
    }

    public void printEpics() {

        for (HashMap.Entry entry: epics.entrySet()) {
            System.out.println(entry);
        }
    }

    public void printSubtasks() {
        for (HashMap.Entry entry: subtasks.entrySet()) {
            System.out.println(entry);
        }
    }

    public void clearTasks() {
        tasks.clear();
    }

    public void clearEpics() {
        epics.clear();
    }

    public void clearSubtasks() {
        subtasks.clear();
    }

    public void clearingATaskByID(int id) {
        tasks.remove(id);
    }

    public void clearingAEpicByID(int id) {
        epics.remove(id);
    }

    public void clearingASubtaskByID(int id) {
        subtasks.remove(id);
    }

    public void receivingByIDTask(int id) {
        Task result = tasks.get(id);
        System.out.println(result);
    }

    public void receivingByIDEpic(int id) {
        Epic result = epics.get(id);
        System.out.println(result);
    }

    public void receivingByIDSubtask(int id) {
        Subtask result = subtasks.get(id);
        System.out.println(result);
    }
}