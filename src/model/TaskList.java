// src/model/TaskList.java
package model;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;
    private int priority;  // Can be 1 (High), 2 (Medium), 3 (Low)

    public TaskList(int priority) {
        this.tasks = new ArrayList<>();
        this.priority = priority;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
