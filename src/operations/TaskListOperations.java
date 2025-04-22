// src/operations/TaskListOperations.java
package operations;

import model.Task;

import java.util.List;

public interface TaskListOperations {
    void addTask(Task task);
    void removeTask(Task task);
    List<Task> getAllTasks();
    void sortTasksByDueDate();
    void searchTask(String keyword);
    void editTask();
}
