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
        relatedEpic.getSubtaskIds().add(subtask.getId());
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
        for (Epic epic : epics.values()) {
            epic.setStatus(TaskStatus.NEW);
        }
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    public void deleteEpicById(int id) {
        Epic epic = epics.get(id);
        for(int idS : epic.getSubtaskIds()) {
            subtasks.remove(idS);
            epics.remove(id);
        }
    }

    public void deleteSubtaskById(int id, Epic epic) {
        epic.getSubtaskIds().remove(id);
        subtasks.remove(id);
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

    public ArrayList <Subtask> getSubtasksByEpicId(int id) {
        ArrayList<Subtask> subtasksByEpic = new ArrayList<>();
        for(Integer idS : epics.get(id).getSubtaskIds()) {
            subtasksByEpic.add(subtasks.get(idS));
        }
        return subtasksByEpic;
    }

    private void changeEpicStatus(Epic epic) {
        if (epic.getSubtaskIds().isEmpty()) {
            epic.setStatus(TaskStatus.NEW);
        } else {
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
}