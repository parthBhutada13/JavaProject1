// src/implementation/SearchManager.java
package implementation;

import model.Task;
import operations.SearchingOperations;

import java.util.ArrayList;
import java.util.List;

public class SearchManager implements SearchingOperations {

    private List<Task> allTasks;

    public SearchManager(List<Task> allTasks) {
        this.allTasks = allTasks;
    }

    @Override
    public Task searchTaskByTitle(String title) {
        for (Task task : allTasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found Task: " + task.getTitle() + " (ID: " + task.getId() + ")");
                return task;
            }
        }
        System.out.println("Task not found.");
        return null;
    }

    @Override
    public List<Task> searchTasksByCategory(String category) {
        // You can later expand Task with a `category` field to fully support this
        System.out.println("Category-based search is not supported yet.");
        return new ArrayList<>();
    }

    @Override
    public List<Task> searchListByTitle(String title) {
        // Placeholder logic — assumes lists are managed elsewhere with titles
        System.out.println("List-based search not implemented yet.");
        return new ArrayList<>();
    }

    public void updateTaskList(List<Task> tasks) {
        this.allTasks = tasks;
    }
}
