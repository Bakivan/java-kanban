package ru.yandex.practicum.tasktracker.service;

import ru.yandex.practicum.tasktracker.model.Task;
import ru.yandex.practicum.tasktracker.model.Subtask;
import ru.yandex.practicum.tasktracker.model.Epic;
import ru.yandex.practicum.tasktracker.model.TaskStatus;

import java.util.ArrayList;
import java.util.HashMap;


public class TaskManager {

    private HashMap<Integer, Task> tasks= new HashMap<>();

    private HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private int id = 0;

    public ArrayList <Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    public ArrayList <Subtask> getSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    public ArrayList <Epic> getEpics() {
        return new ArrayList<>(epics.values());
    }

    public void createTask(Task task) {
        task.setId(id++);
        tasks.put(task.getId(), task);
    }

    public void createEpic(Epic epic) {
        epic.setId(id++);
        epic.setStatus(TaskStatus.NEW);
        epics.put(epic.getId(), epic);
    }

    public void createSubtask(Subtask subtask) {
        subtask.setId(id++);
        epics.get(subtask.getEpicId()).getSubtaskIds().add(subtask.getId());
        subtasks.put(subtask.getId(), subtask);
        changeEpicStatus(epics.get(subtask.getEpicId()));
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        changeEpicStatus(epics.get(subtask.getEpicId()));
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
        for (Epic epic : epics.values()) {
            epic.setStatus(TaskStatus.NEW);
        }
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    public void deleteEpicById(int id) {
        Epic epic = epics.get(id);
        for (int subtaskId : epic.getSubtaskIds()) {
            subtasks.remove(subtaskId);
        }
        epics.remove(id);
    }

    public void deleteSubtaskById(int id) {
        Epic epic = epics.get(subtasks.get(id).getEpicId());
        ArrayList<Integer> subtaskIds = epic.getSubtaskIds();
        subtaskIds.remove(Integer.valueOf(id));
        subtasks.remove(id);
        changeEpicStatus(epic);
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public Epic getEpicById(int id) {
        return epics.get(id);
    }

    public Subtask getSubtaskById(int id) {
        return subtasks.get(id);
    }

    public ArrayList <Subtask> getSubtasksByEpicId(int epicId) {
        ArrayList<Subtask> subtasksByEpic = new ArrayList<>();
        for (Integer subtaskId : epics.get(id).getSubtaskIds()) {
            subtasksByEpic.add(subtasks.get(subtaskId));
        }
        return subtasksByEpic;
    }

    private void changeEpicStatus(Epic epic) {
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

