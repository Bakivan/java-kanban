package ru.yandex.practicum.tasktracker.exception;

public class ManagerSaveException extends RuntimeException {
    public ManagerSaveException(String message) {
        super(message);
    }
}
