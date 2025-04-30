// src/model/SimpleTask.java
package model;

import java.time.LocalDate;

public class SimpleTask extends Task {
    private LocalDate dueDate;

    public SimpleTask(int id, String title, String description, LocalDate dueDate) {
        super(id, title, description);
        this.dueDate = dueDate;
    }

    @Override
    public LocalDate getDueDate() {
        return this.dueDate;
    }


    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String getTaskType() {
        return "SimpleTask";
    }





}
