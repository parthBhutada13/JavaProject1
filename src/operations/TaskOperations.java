package operations;

import model.Task;
import java.util.Collection;

public interface TaskOperations {
    void createTask();
    void editTask(int taskId);
    void deleteTask(int taskId);
    void markAsComplete(int taskId);
    void getTaskDetails(int taskId);

    // ✅ Added correctly
    Collection<Task> getAllTasks();
}
