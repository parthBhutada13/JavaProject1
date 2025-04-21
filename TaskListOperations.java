package operations;

import java.util.List;
import model.Task;

public interface TaskListOperations {
    void addTask(Task var1);

    void removeTask(Task var1);

    List<Task> getAllTasks();

    void sortTasksByDueDate();

    void searchTask(String var1);

    void editTask();
}
