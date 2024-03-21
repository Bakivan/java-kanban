package ru.yandex.practicum.tasktracker.model;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Integer> sintaskIds = new ArrayList<>();

    public Epic(String name, String description, TaskStatus status, int id) {
        super(name, description, status, id);
    }

    public ArrayList<Integer> getSintaskIds() {
        return sintaskIds;
    }

    public void setSintaskIds(ArrayList<Integer> sintaskIds) {
        this.sintaskIds = sintaskIds;
    }
}