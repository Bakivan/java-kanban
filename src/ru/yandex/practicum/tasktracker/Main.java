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

        Task task1 = new Task("Task1", "Desc1", TaskStatus.NEW);
        Task task2 = new Task("Task2", "Desc2", TaskStatus.NEW);

        inMemoryTaskManager.saveTask(task1);
        inMemoryTaskManager.saveTask(task2);

        System.out.println(inMemoryTaskManager.getTasks());
        System.out.println();

        Task task1Clone = (Task) task1.clone();
        Task task2Clone = (Task) task2.clone();

        task1Clone.setStatus(TaskStatus.IN_PROGRESS);
        task2Clone.setStatus(TaskStatus.DONE);

        inMemoryTaskManager.updateTask(task1Clone);
        inMemoryTaskManager.updateTask(task2Clone);

        System.out.println(inMemoryTaskManager.getTasks());
        System.out.println(inMemoryTaskManager.getHistory());

        Epic epic1 = new Epic("Epic1", "Desc1");
        Epic epic2 = new Epic("Epic2", "Desc2");

        Subtask subtask1 = new Subtask("Subtask1", "Desk1");
        Subtask subtask2 = new Subtask("Subtask2", "Desk2");
        Subtask subtask3 = new Subtask("Subtask3", "Desk3");


        inMemoryTaskManager.saveEpic(epic1);
        inMemoryTaskManager.saveEpic(epic2);
        subtask1.setEpicIdForThisSubtask(epic1.getId());
        subtask2.setEpicIdForThisSubtask(epic1.getId());
        subtask3.setEpicIdForThisSubtask(epic2.getId());

        inMemoryTaskManager.saveSubtask(subtask1);
        inMemoryTaskManager.saveSubtask(subtask2);
        inMemoryTaskManager.saveSubtask(subtask3);

        System.out.println(inMemoryTaskManager.getSubtasks());
        System.out.println();

        Subtask subtask1Clone = (Subtask) subtask1.clone();
        Subtask subtask3Clone = (Subtask) subtask3.clone();

        subtask1Clone.setStatus(TaskStatus.IN_PROGRESS);
        subtask3Clone.setStatus(TaskStatus.DONE);
        inMemoryTaskManager.updateSubtask(subtask1Clone);
        inMemoryTaskManager.updateSubtask(subtask3Clone);

        System.out.println(inMemoryTaskManager.getEpics());
        System.out.println(inMemoryTaskManager.getSubtasks());
        System.out.println();

        inMemoryTaskManager.deleteSubtasks();
        System.out.println(inMemoryTaskManager.getEpics());
        System.out.println();

        System.out.println(inMemoryTaskManager.getHistory());

    }

}