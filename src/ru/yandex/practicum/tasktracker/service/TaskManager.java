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
        subtask.setStatus(TaskStatus.NEW);
        Epic relatedEpic = epics.get(subtask.getEpicId());
        ArrayList <Integer> sintaskIds = relatedEpic.getSintaskIds();
        sintaskIds.add(subtask.getId());
        subtasks.put(subtask.getId(), subtask);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    public void updateSubtask(Subtask subtask) {
        Epic epic = epics.get(subtask.getEpicId());
        epic.setStatus(subtask.getStatus());
        subtasks.put(subtask.getId(), subtask);
    }

    public void clearTasks() {
        tasks.clear();
    }

    public void clearEpics() {
        epics.clear();
        subtasks.clear();
    }

    public void clearSubtasks() {
        subtasks.clear();
        for (HashMap.Entry<Integer, Epic> entry : epics.entrySet()) {
            Epic epic = entry.getValue();
            epic.setStatus(TaskStatus.NEW);
        }
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    public void deleteEpicById(int id) {
        epics.remove(id);
    }

    public void deleteSubtaskById(int id) {
        subtasks.remove(id);
    }

    public Task receivingByIdtask(int id) {
        Task result = tasks.get(id);
        return result;
    }

    public Epic receivingByIdEpic(int id) {
        Epic result = epics.get(id);
        return result;
    }

    public Subtask receivingByIdSubtask(int id) {
        Subtask result = subtasks.get(id);
        return result;
    }

    public ArrayList <Integer> getListSubtasks(Epic epic) {
        ArrayList <Integer> subtasks = epic.getSintaskIds();
        return subtasks;
    }
}