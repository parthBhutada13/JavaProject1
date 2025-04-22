// src/operations/SortingOperations.java
package operations;

import model.Task;
import java.util.Comparator;
import java.util.List;

public interface SortingOperations {
    void sortByDueDate(List<Task> tasks);
    void sortByCompletionStatus(List<Task> tasks);
    List<Task> sortTasks(List<Task> tasks, Comparator<Task> comparator);
}
