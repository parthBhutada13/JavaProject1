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

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isComplete() {
        return this.isComplete;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract String getTaskType();

    public LocalDate getDueDate() {
        return null;
    }

    public abstract void setDueDate(LocalDate var1);
}
