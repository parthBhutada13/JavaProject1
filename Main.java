import cli.TaskManagerCLI;
import implementation.ProjectManager;
import implementation.SearchManager;
import implementation.Sorter;
import implementation.TaskListManager;
import implementation.TaskManager;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        TaskListManager taskListManager = new TaskListManager(1);
        ProjectManager projectManager = new ProjectManager();
        Sorter sorter = new Sorter();
        SearchManager searchManager = new SearchManager(new ArrayList(taskManager.getAllTasks()));
        System.out.println("\ud83d\udd25 Welcome to CLI Task Manager!");
        System.out.println("Launching CLI interface...\n");
        TaskManagerCLI cli = new TaskManagerCLI(taskManager, taskListManager, projectManager, sorter, searchManager);
        cli.run();
    }
}
