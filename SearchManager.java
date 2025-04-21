package implementation;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import operations.SearchingOperations;

public class SearchManager implements SearchingOperations {
    private List<Task> allTasks;

    public SearchManager(List<Task> allTasks) {
        this.allTasks = allTasks;
    }

    public Task searchTaskByTitle(String title) {
        for(Task task : this.allTasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                PrintStream var10000 = System.out;
                String var10001 = task.getTitle();
                var10000.println("Found Task: " + var10001 + " (ID: " + task.getId() + ")");
                return task;
            }
        }

        System.out.println("Task not found.");
        return null;
    }

    public List<Task> searchTasksByCategory(String category) {
        System.out.println("Category-based search is not supported yet.");
        return new ArrayList();
    }

    public List<Task> searchListByTitle(String title) {
        System.out.println("List-based search not implemented yet.");
        return new ArrayList();
    }

    public void updateTaskList(List<Task> tasks) {
        this.allTasks = tasks;
    }
}
