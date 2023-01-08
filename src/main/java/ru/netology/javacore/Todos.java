package ru.netology.javacore;

import java.util.*;

public class Todos {

    private ArrayList<String> allTasks;

    public Todos() {
        this.allTasks = new ArrayList<>();
    }

    public void addTask(String task) {
        this.allTasks.add(task);
    }

    public void removeTask(String task) {
        this.allTasks.remove(task);
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(this.allTasks);
        for (String task : this.allTasks) {
            sb.append(task);
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Todos{" +
                "allTasks=" + allTasks +
                '}';
    }
}