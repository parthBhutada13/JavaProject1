package operations;

import java.util.List;
import model.Task;

public interface ProjectOperations {
    void addMember(String var1);

    void removeMember(String var1);

    void assignTask(String var1, Task var2);

    List<Task> getTasksByMember(String var1);
}
