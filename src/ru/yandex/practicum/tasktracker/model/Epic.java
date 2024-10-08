package ru.yandex.practicum.tasktracker.model;

import java.util.HashMap;
import java.util.Map;

public class Epic extends Task {
    private final Map<Integer, Subtask> subtasksForThisEpic;

    public Epic(String name, String description) {
        super(name, description, TaskStatus.NEW);

        subtasksForThisEpic = new HashMap<>();
    }

    public void addSubtasksForThisEpic(Subtask subtask) {
        if (!subtasksForThisEpic.containsKey(subtask.getId())) {
            subtasksForThisEpic.put(subtask.getId(), subtask);
        } else {
            System.out.println("Данная подзадача уже сохранена в Эпике");
        }
    }

    public void deleteSubtaskForThisEpic(int id) {
        if (subtasksForThisEpic.containsKey(id)) {
            subtasksForThisEpic.remove(id);
        } else {
            System.out.println("У этого Эпика нет такой подзадачи");
        }
    }

    public Map<Integer, Subtask> getSubtasksForThisEpic() {
        return subtasksForThisEpic;
    }

}
