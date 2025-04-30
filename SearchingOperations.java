package operations;

import java.util.List;
import model.Task;

public interface SearchingOperations {
    Task searchTaskByTitle(String var1);

    List<Task> searchTasksByCategory(String var1);

    List<Task> searchListByTitle(String var1);
}
