package ru.netology.javacore;

public class TaskManager {

    String type;
    String task;

    public TaskManager(String type, String task) {
        this.type = type;
        this.task = task;
    }

    @Override
    public String toString() {
        return "type = " + type + ", task = " + task;
    }
}