package operations;

import java.util.Comparator;
import java.util.List;
import model.Task;

public interface SortingOperations {
    void sortByDueDate(List<Task> var1);

    void sortByCompletionStatus(List<Task> var1);

    List<Task> sortTasks(List<Task> var1, Comparator<Task> var2);
}
