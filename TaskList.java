package model;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks = new ArrayList();
    private int priority;

    public TaskList(int priority) {
        this.priority = priority;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
