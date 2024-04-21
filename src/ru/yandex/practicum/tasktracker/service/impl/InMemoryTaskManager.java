package ru.yandex.practicum.tasktracker.service.impl;

import ru.yandex.practicum.tasktracker.model.Epic;
import ru.yandex.practicum.tasktracker.model.Subtask;
import ru.yandex.practicum.tasktracker.model.Task;
import ru.yandex.practicum.tasktracker.model.TaskStatus;
import ru.yandex.practicum.tasktracker.service.HistoryManager;
import ru.yandex.practicum.tasktracker.service.TaskManager;
import ru.yandex.practicum.tasktracker.utilities.Managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {
    private HashMap<Integer, Task> tasks= new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();

    private final HistoryManager historyManager;
    private int id = 0;

    public InMemoryTaskManager() {
        tasks = new HashMap<>();
        subtasks = new HashMap<>();
        epics = new HashMap<>();
        historyManager = Managers.getDefaultHistory();
        id = 0;
    }


    public HistoryManager getHistoryManager() {
        return historyManager;
    }
    @Override
    public ArrayList <Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }
    @Override
    public ArrayList <Subtask> getSubtasks() {
        return new ArrayList<>(subtasks.values());
    }
    @Override
    public ArrayList <Epic> getEpics() {
        return new ArrayList<>(epics.values());
    }
    @Override
    public void createTask(Task task) {
        task.setId(id++);
        tasks.put(task.getId(), task);
    }
    @Override
    public void createEpic(Epic epic) {
        epic.setId(id++);
        epic.setStatus(TaskStatus.NEW);
        epics.put(epic.getId(), epic);
    }
    @Override
    public void createSubtask(Subtask subtask) {
        subtask.setId(id++);
        epics.get(subtask.getEpicId()).getSubtaskIds().add(subtask.getId());
        subtasks.put(subtask.getId(), subtask);
        changeEpicStatus(epics.get(subtask.getEpicId()));
    }
    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }
    @Override
    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }
    @Override
    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        changeEpicStatus(epics.get(subtask.getEpicId()));
    }
    @Override
    public void clearTasks() {
        tasks.clear();
    }
    @Override
    public void clearEpics() {
        epics.clear();
        subtasks.clear();
    }
    @Override
    public void clearSubtasks() {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            epic.setStatus(TaskStatus.NEW);
        }
    }
    @Override
    public void deleteTaskById(int id) {
        tasks.remove(id);
    }
    @Override
    public void deleteEpicById(int id) {
        Epic epic = epics.get(id);
        for (int subtaskId : epic.getSubtaskIds()) {
            subtasks.remove(subtaskId);
        }
        epics.remove(id);
    }
    @Override
    public void deleteSubtaskById(int id) {
        Epic epic = epics.get(subtasks.get(id).getEpicId());
        ArrayList<Integer> subtaskIds = epic.getSubtaskIds();
        subtaskIds.remove(Integer.valueOf(id));
        subtasks.remove(id);
        changeEpicStatus(epic);
    }
    @Override
    public Task getTaskById(int id) {
        return tasks.get(id);
    }
    @Override
    public Epic getEpicById(int id) {
        return epics.get(id);
    }
    @Override
    public Subtask getSubtaskById(int id) {
        return subtasks.get(id);
    }
    @Override
    public ArrayList <Subtask> getSubtasksByEpicId(int epicId) {
        ArrayList<Subtask> subtasksByEpic = new ArrayList<>();
        for (Integer subtaskId : epics.get(id).getSubtaskIds()) {
            subtasksByEpic.add(subtasks.get(subtaskId));
        }
        return subtasksByEpic;
    }
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }
    @Override
    public void changeEpicStatus(Epic epic) {
        if (epic.getSubtaskIds().isEmpty()) {
            epic.setStatus(TaskStatus.NEW);
            return;
        }
        int countNew = 0;
        int countDone = 0;
        ArrayList<Integer> forStatus = epic.getSubtaskIds();
        for (Integer id : forStatus) {
            if (subtasks.get(id).getStatus() == TaskStatus.IN_PROGRESS) {
                epic.setStatus(TaskStatus.IN_PROGRESS);
                return;
            } else if (subtasks.get(id).getStatus() == TaskStatus.NEW) {
                countNew++;
            } else if (subtasks.get(id).getStatus() == TaskStatus.DONE) {
                countDone++;
            }
        }
        if (countNew == forStatus.size()) {
            epic.setStatus(TaskStatus.NEW);
        } else if (countDone == forStatus.size()) {
            epic.setStatus(TaskStatus.DONE);
        } else {
            epic.setStatus(TaskStatus.IN_PROGRESS);
        }
    }
}


