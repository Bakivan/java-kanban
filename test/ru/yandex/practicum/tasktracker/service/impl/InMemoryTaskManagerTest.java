package ru.yandex.practicum.tasktracker.service.impl;

class InMemoryTaskManagerTest extends TaskManagerTest<InMemoryTaskManager> {

    @Override
    public InMemoryTaskManager createTaskManager() {
        return taskManager = new InMemoryTaskManager();
    }
}