// src/model/Task.java
package model;

import java.time.LocalDate;

public abstract class Task {
    protected int id;
    protected String title;
    protected String description;
    protected boolean isComplete;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isComplete = false;
    }

    public void markAsComplete() {
        this.isComplete = true;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isComplete() { return isComplete; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }

    // Abstract method for subclasses to implement
    public abstract String getTaskType();
    public LocalDate getDueDate(){
        return null;
    };
    public abstract void setDueDate(LocalDate dueDate);
}
