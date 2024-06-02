package ru.yandex.practicum.tasktracker.utilities;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.tasktracker.service.HistoryManager;
import ru.yandex.practicum.tasktracker.service.TaskManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ManagerTest {

    @Test
    void newTaskManager() {
        TaskManager taskManager = Managers.getDefault();

        assertNotNull(taskManager, "Менеджер не проинициализирован");
    }

    @Test
    void newHistoryManager() {
        HistoryManager historyManager = Managers.getDefaultHistory();

        assertNotNull(historyManager, "Менеджер не проинициализирован");
    }

}
