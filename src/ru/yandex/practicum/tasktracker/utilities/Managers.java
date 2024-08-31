package ru.yandex.practicum.tasktracker.utilities;

import ru.yandex.practicum.tasktracker.service.HistoryManager;
import ru.yandex.practicum.tasktracker.service.TaskManager;
import ru.yandex.practicum.tasktracker.service.impl.FileBackedTaskManager;
import ru.yandex.practicum.tasktracker.service.impl.InMemoryHistoryManager;
import ru.yandex.practicum.tasktracker.service.impl.InMemoryTaskManager;

import java.io.File;

public class Managers {

    private Managers() {
    }

    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }

    public static FileBackedTaskManager getDefaultFileManager(File file) {
        return FileBackedTaskManager.newFileBackedTaskManager(file);
    }

    public static FileBackedTaskManager getLoadedFileManager(File file) {
        return FileBackedTaskManager.loadTaskManagerFromFile(file);
    }

}
