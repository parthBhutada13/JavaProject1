// src/operations/SearchingOperations.java
package operations;

import model.Task;

import java.util.List;

public interface SearchingOperations {
    Task searchTaskByTitle(String title);
    List<Task> searchTasksByCategory(String category);  // if category is added later
    List<Task> searchListByTitle(String title);
}
