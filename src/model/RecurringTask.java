// src/model/RecurringTask.java
package model;

import java.time.LocalDate;

public class RecurringTask extends Task {
    private String recurrencePattern;
    private LocalDate dueDate;

    public RecurringTask(int id, String title, String description, LocalDate dueDate, String recurrencePattern) {
        super(id, title, description);
        this.dueDate = dueDate;
        this.recurrencePattern = recurrencePattern;
    }

    public String getRecurrencePattern() {
        return recurrencePattern;
    }

    public void setRecurrencePattern(String recurrencePattern) {
        this.recurrencePattern = recurrencePattern;
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
        return "RecurringTask";
    }
}
