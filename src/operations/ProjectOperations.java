// src/operations/// src/Main.java
//import cli.TaskManagerCLI;
//import implementation.*;
//import model.Task;
//
//import java.util.List;
//import java.util.Scanner;
//import java.util.ArrayList;
//
//
//
//public class Main {
//    public static void main(String[] args) {
//
//        // Initialize components
//        TaskManager taskManager = new TaskManager();
//        TaskListManager taskListManager = new TaskListManager(1); // default priority
//        ProjectManager projectManager = new ProjectManager();
//        Sorter sorter = new Sorter();
//
//        // SearchManager can be updated with all tasks dynamically
//        SearchManager searchManager = new SearchManager(new ArrayList<>(taskManager.getAllTasks()));
//
//        System.out.println("🔥 Welcome to CLI Task Manager!");
//        System.out.println("Launching CLI interface...\n");
//
//        // Pass components into CLI handler
//        TaskManagerCLI cli = new TaskManagerCLI(taskManager, taskListManager, projectManager, sorter, searchManager);
//        cli.run();  // Start the interactive CLI
//    }
//}
package operations;

import model.Task;

import java.util.List;

public interface ProjectOperations {
    void addMember(String name);
    void removeMember(String name);
    void assignTask(String member, Task task);
    List<Task> getTasksByMember(String member);
}
