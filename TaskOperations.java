package operations;

import java.util.Collection;
import model.Task;

public interface TaskOperations {
    void createTask();

    void editTask(int var1);

    void deleteTask(int var1);

    void markAsComplete(int var1);

    void getTaskDetails(int var1);

    Collection<Task> getAllTasks();
}
