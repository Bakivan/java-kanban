package ru.yandex.practicum.tasktracker.service;

import ru.yandex.practicum.tasktracker.model.Task;
import ru.yandex.practicum.tasktracker.model.Subtask;
import ru.yandex.practicum.tasktracker.model.Epic;

import java.util.ArrayList;
import java.util.HashMap;


public class TaskManager {
    HashMap<Integer, Task> taskMap= new HashMap<>();
    HashMap<Integer, Subtask> subtaskMap = new HashMap<>();
    HashMap<Integer, Epic> epicMap = new HashMap<>();
    ArrayList<Integer> idSubtask = new ArrayList<>();
    private int id = 0;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private void  getNextId() {
        //counterId()
        id++;
        setId(id);
    }

    public void createTask(Task task) { //Создание задач
        getNextId();
        taskMap.put(getId(),task);

    }
    public void createEpic(Epic epic) { // Создание эпиков
        getNextId();
        epicMap.put(getId(),epic);
    }
    public void createSubtask(Subtask subtask) { // Создание подзадач
        getNextId();
        idSubtask.add(getId());
        subtaskMap.put(getId(),subtask);
    }
    public void updateTask(int id, Task task) { //Обновление задач
        taskMap.put(id, task);

    }
    public void updateEpic(int id, Epic epic) { //Обновление эпиков
        epicMap.put(id, epic);
    }
    public void updateSubtask(int id, Subtask subtask) { //Обновление подзадач
        subtaskMap.put(id, subtask);
    }
    public void printTasks() { //Получение списка всех задач

        for (HashMap.Entry entry: taskMap.entrySet()) {
            System.out.println(entry);
        }
    }
    public void printEpics() { //Получение списка всех эпиков

        for (HashMap.Entry entry: epicMap.entrySet()) {
            System.out.println(entry);
        }
    }
    public void printSubtasks() { //Получение списка всех подзадач
        for (HashMap.Entry entry: subtaskMap.entrySet()) {
            System.out.println(entry);
        }
    }
    public void clearTasks() { // Удаление всех задач
        taskMap.clear();
    }
    public void clearEpics() { // Удаление всех эпиков
        epicMap.clear();
    }
    public void clearSubtasks() { //Удаление всех подзадач
        subtaskMap.clear();
    }
    public void clearingATaskByID(int id) { //Удаление задачи по идентификатору
        taskMap.remove(id);
    }
    public void clearingAEpicByID(int id) { //Удаление эпика по идентификатору
        epicMap.remove(id);
    }
    public void clearingASubtaskByID(int id) { //Удаление подзадачи по идентификатору
        subtaskMap.remove(id);
    }
    public void receivingByIDTask(int id) { //Получение по идентификатору задачи
        Task result = taskMap.get(id);
        System.out.println(result);
    }
    public void receivingByIDEpic(int id) { //Получение по идентификатору эпика
        Epic result = epicMap.get(id);
        System.out.println(result);
    }
    public void receivingByIDSubtask(int id) { //Получение по идентификатору подзадачи
        Subtask result = subtaskMap.get(id);
        System.out.println(result);
    }
}
